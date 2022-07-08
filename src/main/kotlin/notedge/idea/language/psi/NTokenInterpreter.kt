package notedge.idea.language.psi

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

@OptIn(ExperimentalStdlibApi::class)
@Suppress("MemberVisibilityCanBePrivate")
class NTokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int, var context: Int) {
    //URL= [A-Za-z0-9]+:"//"[\-\p{XID_Continue}./?&#]+
    //SYMBOL=[\p{XID_Start}_][\p{XID_Continue}_]*
    //STRING=\"([^\"\\]|\\.)*\"
    //BYTE=(0[bBoOxXfF][0-9A-Fa-f][0-9A-Fa-f_]*)
    //INTEGER=(0|[1-9][0-9_]*)
    //DECIMAL=([0-9]+\.[0-9]*([*][*][0-9]+)?)|(\.[0-9]+([Ee][0-9]+)?)
    //SIGN=[+-]
    //HEADER_HASH=[#]+
    companion object {
        private val EOL = "\\R".toRegex()
        private val WHITE_SPACE = "[^\\S\\r\\n]+".toRegex()
        private val NEW_LINE = "[\\r\\n]".toRegex()
        private val HEADER_HASH = "#+".toRegex()
        private val ASTERISK = "[*]+".toRegex()
        private val TILDE = "~+".toRegex()
        private val ESCAPE = "\\\\".toRegex()
        private val SYMBOL = "[\\p{ASCII}_][\\p{ASCII}_]*".toRegex()
    }

    private var stack: MutableList<StackItem> = mutableListOf()

    fun interpreter(): MutableList<StackItem> {
        while (startOffset < endOffset) {
            if (matchesWhitespace()) continue
            if (matchesNewline()) continue
            if (matchesHeadHash()) continue
            if (matchesEscape()) continue
            if (matchesSymbol()) continue
            break
        }
        checkRest()
        return stack
    }

    fun matchesWhitespace(): Boolean {
        val r = WHITE_SPACE.matchAt(buffer, startOffset) ?: return false;
        stack.add(StackItem(TokenType.WHITE_SPACE, r.range.first, r.range.last, context))
        return addOffset(r)
    }

    fun matchesNewline(): Boolean {
        val r = NEW_LINE.matchAt(buffer, startOffset) ?: return false;
        if (shouldBreakHeader()) {
            stack.add(StackItem(NoteTypes.BREAK_PART, r.range.first, r.range.last, context))
        } else {
            stack.add(StackItem(NoteTypes.NEW_LINE, r.range.first, r.range.last, context))
        }
        return addOffset(r)
    }

    fun matchesHeadHash(): Boolean {
        val r = HEADER_HASH.matchAt(buffer, startOffset) ?: return false;
        stack.add(StackItem(NoteTypes.HEADER_HASH, r.range.first, r.range.last, context))
        return addOffset(r)
    }

    fun matchesEscape(): Boolean {
        val r = ESCAPE.matchAt(buffer, startOffset) ?: return false;
        stack.add(StackItem(NoteTypes.ESCAPE, r.range.first, r.range.last, context))
        return addOffset(r)
    }

    fun matchesSymbol(): Boolean {
        val r = SYMBOL.matchAt(buffer, startOffset) ?: return false;
        when {
            lastIs(NoteTypes.ESCAPE) -> {
                stack.add(StackItem(NoteTypes.SYMBOL, r.range.first, r.range.last, context))
            }

            else -> {
                stack.add(StackItem(NoteTypes.PLAIN_TEXT, r.range.first, r.range.last, context))
            }
        }
        return addOffset(r)
    }

    fun matchesAsterisk(): Boolean {
        val r = ASTERISK.matchAt(buffer, startOffset) ?: return false;
        val last = lastAsterisk();
//        if (last == null || last > length) {
//            when (length) {
//                1 -> {
//                    lookAheadBuffer.add(NoteTypes.ITALIC_L)
//                }
//                2 -> {
//                    lookAheadBuffer.add(NoteTypes.BOLD_L)
//                }
//                3 -> {
//                    lookAheadBuffer.add(NoteTypes.ITALIC_BOLD_L)
//                }
//                else -> {
//                    lookAheadBuffer.add(NoteTypes.PLAIN_TEXT)
//                    return lastLookAhead
//                }
//            }
//            // stack.add(StackItem.Asterisk(length))
//
//        }
//        // if (last == here.yylength())
//        else {
//            when (length) {
//                1 -> {
//                    asteriskStack.removeLast()
//                    lookAheadBuffer.add(NoteTypes.ITALIC_R)
//                }
//                2 -> {
//                    asteriskStack.removeLast()
//                    lookAheadBuffer.add(NoteTypes.BOLD_R)
//                }
//                3 -> {
//                    asteriskStack.removeLast()
//                    lookAheadBuffer.add(NoteTypes.ITALIC_BOLD_R)
//                }
//                else -> TODO("unreachable")
//            }
//        }
        return addOffset(r)
    }

    fun checkRest() {
        if (startOffset < endOffset) {
            stack.add(StackItem(NoteTypes.PLAIN_TEXT, startOffset, endOffset, context))
        }
    }

    fun lastIs(token: IElementType): Boolean = when (val last = stack.lastOrNull()) {
        null -> false
        else -> last.token == token
    }

    fun lastAsterisk(): Boolean {
//        for (item in stack.reversed()) {
//            if (item.token == NoteTypes.ITALIC_L) {
//                return true
//            }
//        }
        TODO()
    }

    fun shouldBreakHeader(): Boolean {
        for (item in stack.reversed()) {
            if (item.token == NoteTypes.HEADER_HASH) {
                return true
            }
        }
        return false
    }

    fun addOffset(r: MatchResult): Boolean {
        startOffset = r.range.last + 1
        return true
    }
}