package notedge.idea.language.psi

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

@OptIn(ExperimentalStdlibApi::class)
@Suppress("MemberVisibilityCanBePrivate")
class NTokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int, var context: StackContext) {
    companion object {
        val EOL = "\\R".toRegex()
        val WHITE_SPACE = "[^\\S\\r\\n]+".toRegex()
        val NEW_LINE = "\\r\\n|\\r|\\n".toRegex()
        val HEADER_HASH = "[＃#]+".toRegex()
        val ASTERISK = "[*]+".toRegex()
        val TILDE = "[_＿]+".toRegex()
        val ESCAPE = "[\\\\＼]".toRegex()
        val SYMBOL = "[\\p{L}\\p{N}][\\p{L}_]*".toRegex()
        val CODE = "[`｀]+".toRegex()
        val PARENTHESIS_L = "[(（]".toRegex()
        val PARENTHESIS_R = "[)）]".toRegex()
        val BRACKET_L = "[\\[［]".toRegex()
        val BRACKET_R = "[]］]".toRegex()
        val BRACE_L = "[{｛]".toRegex()
        val BRACE_R = "[}｝]".toRegex()
        val DOUBLE_QUOTE = "[\"＂]".toRegex()
        val SINGLE_QUOTE = "['＇]".toRegex()
        val ANGLE_SL = "</|＜／".toRegex()
        val ANGLE_L = "[<＜]".toRegex()
        val ANGLE_R = "[>＞]".toRegex()
        val ANGLE_SR = "/>|／＞".toRegex()
    }

    var stack: MutableList<StackItem> = mutableListOf()

    fun interpreter(): Array<StackItem> {
        while (startOffset < endOffset) {
            if (matchesWhitespace()) continue
            if (matchesNewline()) continue
            if (matchesHeadHash()) continue
            if (matchesAsterisk()) continue
            if (matchesTilde()) continue
            if (matchesCode()) continue
            if (matchesEscape()) continue
            if (matchesSymbol()) continue
            break
        }
        checkRest()
        return stack.toTypedArray()
    }

    fun matchesWhitespace(): Boolean {
        val r = WHITE_SPACE.matchAt(buffer, startOffset) ?: return false
        when (context) {
            StackContext.TEXT -> stack.add(StackItem(TokenType.WHITE_SPACE, r, context))
            StackContext.CODE -> stack.add(StackItem(TokenType.WHITE_SPACE, r, context))
            StackContext.STRING -> stack.add(StackItem(NoteTypes.STRING_TEXT, r, context))
        }
        return addOffset(r)
    }

    fun matchesNewline(): Boolean {
        val r = NEW_LINE.matchAt(buffer, startOffset) ?: return false
        when (context) {
            StackContext.TEXT -> when {
                shouldBreakParagraph() -> {
                    stack.add(StackItem(NoteTypes.BREAK_PART, r, context))
                }
                else -> {
                    stack.add(StackItem(NoteTypes.NEW_LINE, r, context))
                }
            }
            StackContext.CODE -> stack.add(StackItem(NoteTypes.NEW_LINE, r, context))
            StackContext.STRING -> stack.add(StackItem(NoteTypes.STRING_TEXT, r, context))
        }
        return addOffset(r)
    }

    fun matchesHeadHash(): Boolean {
        val r = HEADER_HASH.matchAt(buffer, startOffset) ?: return false
        when (context) {
            StackContext.TEXT -> stack.add(StackItem(TokenType.WHITE_SPACE, r, context))
            StackContext.CODE -> stack.add(StackItem(TokenType.WHITE_SPACE, r, context))
            StackContext.STRING -> stack.add(StackItem(NoteTypes.STRING_TEXT, r, context))
        }
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

    fun matchesCode(): Boolean {
        val r = CODE.matchAt(buffer, startOffset) ?: return false
        when (r.value.length) {
            1 -> {
                stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
                return addOffset(r)
            }
            2 -> {
                stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
                return addOffset(r)
            }
            else -> {
                when {
                    isStartOfLine() -> {
                        stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
                        return addOffset(r)
                    }
                    else -> {
                        stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
                        return addOffset(r)
                    }
                }
            }
        }

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
                NoteTypes.ITALIC_R -> {
                    stack.add(StackItem(NoteTypes.ITALIC_L, r, context, false))
                    return
                }
                NoteTypes.ITALIC_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.ITALIC_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.ITALIC_L, r, context, false))
    }

    fun matchesBold(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.BOLD_R -> {
                    stack.add(StackItem(NoteTypes.BOLD_L, r, context, false))
                    return
                }
                NoteTypes.BOLD_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.BOLD_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.BOLD_L, r, context, false))
    }

    fun matchesStrong(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.STRONG_R -> {
                    stack.add(StackItem(NoteTypes.STRONG_L, r, context, false))
                    return
                }
                NoteTypes.STRONG_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.STRONG_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.STRONG_L, r, context))
    }

    fun matchesTilde(): Boolean {
        val r = TILDE.matchAt(buffer, startOffset) ?: return false
        when (r.value.length) {
            1 -> matchUnderline(r)
            2 -> matchWave(r)
            3 -> matchStrike(r)
            else -> stack.add(StackItem(NoteTypes.PLAIN_TEXT, r, context))
        }
        return addOffset(r)
    }

    fun matchUnderline(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.UNDER_R -> {
                    stack.add(StackItem(NoteTypes.UNDER_L, r, context, false))
                    return
                }
                NoteTypes.UNDER_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.UNDER_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.UNDER_L, r, context, false))
    }

    fun matchWave(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.WAVE_R -> {
                    stack.add(StackItem(NoteTypes.WAVE_L, r, context, false))
                    return
                }
                NoteTypes.WAVE_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.WAVE_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.WAVE_L, r, context, false))
    }

    fun matchStrike(r: MatchResult) {
        for (item in stack.asReversed()) {
            when (item.token) {
                NoteTypes.BREAK_PART,
                NoteTypes.STRIKE_R -> {
                    stack.add(StackItem(NoteTypes.STRIKE_L, r, context, false))
                    return
                }
                NoteTypes.STRIKE_L -> {
                    item.setPaired()
                    stack.add(StackItem(NoteTypes.STRIKE_R, r, context, true))
                    return
                }
                else -> continue
            }
        }
        stack.add(StackItem(NoteTypes.STRIKE_L, r, context, false))
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

private fun NTokenInterpreter.restOfLine(): String {
    return sequenceAfter().split(NTokenInterpreter.NEW_LINE, 1).firstOrNull() ?: ""
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

private fun NTokenInterpreter.lastIs(token: IElementType): Boolean = when (val last = stack.lastOrNull()) {
    null -> false
    else -> last.token == token
}

private fun NTokenInterpreter.isStartOfLine(): Boolean {
    for (item in this.stack.reversed()) {
        return when (item.token) {
            NoteTypes.NEW_LINE, NoteTypes.BREAK_PART -> true
            TokenType.WHITE_SPACE -> continue
            else -> false
        }
    }
    return true
}