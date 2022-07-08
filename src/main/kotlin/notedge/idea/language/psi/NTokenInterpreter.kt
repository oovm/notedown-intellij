package notedge.idea.language.psi

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
        private val ESCAPE = "\\\\".toRegex()
        private val ASTERISK = "[*]+".toRegex()
        private val TILDE = "~+".toRegex()
        private val HEADER_HASH = "#+".toRegex()
    }

    private var stack: MutableList<StackItem> = mutableListOf()

    @OptIn(ExperimentalStdlibApi::class)
    fun interpreter(): MutableList<StackItem> {
        var res: MatchResult? = null;
        while (startOffset < endOffset) {
            res = WHITE_SPACE.matchAt(buffer, startOffset);
            if (res != null) {
                checkEscape(res)
                continue
            }
            res = ESCAPE.matchAt(buffer, startOffset);
            if (res != null) {
                checkEscape(res)
                continue
            }
            res = HEADER_HASH.matchAt(buffer, startOffset);
            if (res != null) {
                checkHeadHash(res)
                continue
            }
            break
        }
        checkRest()
        return stack
    }

    fun checkHeadHash(r: MatchResult) {
        if (startOffset < endOffset) {
            stack.add(StackItem(NoteTypes.PLAIN_TEXT, startOffset, endOffset, context))
        }
    }

    fun checkEscape(r: MatchResult) {
        stack.add(StackItem(NoteTypes.ESCAPE, r.range.first, r.range.last, context))
        startOffset = r.range.last + 1
    }

    fun checkRest() {
        if (startOffset < endOffset) {
            stack.add(StackItem(NoteTypes.PLAIN_TEXT, startOffset, endOffset, context))
        }
    }
}