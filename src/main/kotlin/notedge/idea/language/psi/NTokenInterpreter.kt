package notedge.idea.language.psi

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

@OptIn(ExperimentalStdlibApi::class)
@Suppress("MemberVisibilityCanBePrivate")
class NTokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int, var context: Int) {
    private class Ref(var value: StackItem)
    companion object {
        private val EOL = "\\R".toRegex()
        private val WHITE_SPACE = "[^\\S\\r\\n]+".toRegex()
        private val NEW_LINE = "\\r\\n|\\r|\\n".toRegex()
        private val HEADER_HASH = "#+".toRegex()
        private val ASTERISK = "[*]+".toRegex()
        private val TILDE = "_+".toRegex()
        private val ESCAPE = "\\\\".toRegex()
        private val SYMBOL = "(?U)[\\p{L}\\p{N}_][\\p{L}_]*".toRegex()
    }

    var stack: MutableList<StackItem> = mutableListOf()

    fun interpreter(): Array<StackItem> {
        while (startOffset < endOffset) {
            if (matchesWhitespace()) continue
            if (matchesNewline()) continue
            if (matchesHeadHash()) continue
            if (matchesEscape()) continue
            if (matchesSymbol()) continue
            break
        }
        checkRest()
        return stack.toTypedArray()
    }

    fun matchesWhitespace(): Boolean {
        val r = WHITE_SPACE.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(TokenType.WHITE_SPACE, r, context))
        return addOffset(r)
    }

    fun matchesNewline(): Boolean {
        val r = NEW_LINE.matchAt(buffer, startOffset) ?: return false
        if (shouldBreakParagraph()) {
            stack.add(StackItem(NoteTypes.BREAK_PART, r, context))
        }
        else {
            stack.add(StackItem(NoteTypes.NEW_LINE, r, context))
        }
        return addOffset(r)
    }

    fun matchesHeadHash(): Boolean {
        val r = HEADER_HASH.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(NoteTypes.HEADER_HASH, r, context))
        return addOffset(r)
    }

    fun matchesEscape(): Boolean {
        val r = ESCAPE.matchAt(buffer, startOffset) ?: return false
        stack.add(StackItem(NoteTypes.ESCAPE, r, context))
        return addOffset(r)
    }

    fun matchesSymbol(): Boolean {
        val r = SYMBOL.matchAt(buffer, startOffset) ?: return false
        when {
            lastIs(NoteTypes.ESCAPE) -> {
                stack.add(StackItem(NoteTypes.SYMBOL, r, context))
            }

            else -> {
                stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
            }
        }
        return addOffset(r)
    }

    fun matchesAsterisk(): Boolean {
        val r = ASTERISK.matchAt(buffer, startOffset) ?: return false
        when (r.value.length) {
            1 -> matchesItalic(r)
            2 -> matchesBold(r)
            3 -> matchesStrong(r)
            else -> stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
        }
        return addOffset(r)
    }

    fun matchesItalic(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.BOLD_L, NoteTypes.BOLD_R,
                NoteTypes.STRONG_L, NoteTypes.STRONG_R -> {
                    // 快速返回
                    stack.add(StackItem(NoteTypes.ITALIC_L, r, context))
                    return
                }
                NoteTypes.ITALIC_L -> {
                    stack.add(StackItem(NoteTypes.ITALIC_R, r, context))
                    return
                }
                else -> continue
            }
        }
        // 兜底情况, 左边全是字符
        stack.add(StackItem(NoteTypes.ITALIC_L, r, context))
    }

    fun matchesBold(r: MatchResult) {
        stack.add(StackItem(NoteTypes.BOLD_L, r, context))
    }

    fun matchesStrong(r: MatchResult) {
        stack.add(StackItem(NoteTypes.STRONG_L, r, context))
    }


    fun checkRest() {
        if (startOffset < endOffset) {
            stack.add(StackItem(NoteTypes.PLAIN_TEXT, startOffset, endOffset, context))
        }
    }

    fun addOffset(r: MatchResult): Boolean {
        startOffset = r.range.last + 1
        return true
    }
}

private fun NTokenInterpreter.sequenceAfter(): CharSequence {
    return buffer.subSequence(startOffset, endOffset)
}

private fun NTokenInterpreter.shouldBreakParagraph(): Boolean {
    for (item in stack.reversed()) {
        return when (item.token) {
            // [#, text, text, |]
            NoteTypes.HEADER_HASH -> true
            // [\n, |]
            NoteTypes.NEW_LINE, NoteTypes.BREAK_PART -> true
            else -> continue
        }
    }
    // [|]
    return false
}

private fun NTokenInterpreter.lastAsterisks(): MutableList<StackItem> {
    var out = mutableListOf<StackItem>()
    for (item in stack.asReversed()) {
        if (item.token == NoteTypes.ITALIC_L) {
            out.add(item)
        }
        else {
            return out
        }
    }
    return out
}

private fun NTokenInterpreter.eraseImbalance() {
    for (item in stack.reversed()) {
        when (item.isSoftLeftMark()) {
            true -> item.token = NoteTypes.PLAIN_TEXT
            false -> break
            null -> continue
        }
    }
}


private fun NTokenInterpreter.lastIs(token: IElementType): Boolean = when (val last = stack.lastOrNull()) {
    null -> false
    else -> last.token == token
}