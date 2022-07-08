package notedge.idea.language.psi

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import notedge.idea._NotedownLexer

class ParsingStack {
    var stack: MutableList<StackItem> = mutableListOf()
    var lookAheadBuffer: MutableList<IElementType> = mutableListOf()

    private var ignoreWhitespaceText = false
    private var canEndLine = false

    fun analyzeWhitespace(here: _NotedownLexer): IElementType {
        lookAheadBuffer.add(TokenType.WHITE_SPACE)
        return lastLookAhead
    }

    fun analyzeHeadHash(here: _NotedownLexer): IElementType {
        if (peekLookAheadNonWhitespace == null) {
            lookAheadBuffer.add(NoteTypes.HEADER_HASH)
        } else {
            lookAheadBuffer.add(NoteTypes.PLAIN_TEXT)
        }
        return lastLookAhead
    }

    fun analyzeCode(here: _NotedownLexer): IElementType {
//        if (stack.lastOrNull() == StackItem.Code) {
//            return NoteTypes.CODE
//        }
        return NoteTypes.ITALIC_L
    }

    fun analyzeStar(here: _NotedownLexer): IElementType {
        lookAheadBuffer.add(NoteTypes.ITALIC_L)
        return lastLookAhead
    }

    fun analyzeEscape(here: _NotedownLexer): IElementType {
        lookAheadBuffer.add(NoteTypes.ESCAPE)
        return lastLookAhead
    }

    fun analyzeSymbol(here: _NotedownLexer): IElementType {
        when (peekLookAhead) {
            NoteTypes.ESCAPE -> {
                lookAheadBuffer.add(NoteTypes.SYMBOL)
            }
            else -> {
                lookAheadBuffer.add(NoteTypes.PLAIN_TEXT)
            }
        }
        return lastLookAhead
    }

    /// reset look ahead
    fun analyzeNewline(here: _NotedownLexer): IElementType {
        when {
            peekLookAhead == null -> {
                lookAheadBuffer.add(NoteTypes.BREAK_PART)
            }
            lookAheadBuffer.contains(NoteTypes.HEADER_HASH) -> {
                lookAheadBuffer.add(NoteTypes.BREAK_PART)
            }
            else -> {
                lookAheadBuffer.add(NoteTypes.NEW_LINE)
            }
        }
        return clearLookAhead
    }
}

private fun ParsingStack.stackHas(item: StackItem): Boolean {
    return stack.contains(item)
}

private val ParsingStack.clearLookAhead: IElementType
    get() {
        val last = lookAheadBuffer.last();
        lookAheadBuffer.clear();
        return last
    }

private inline val ParsingStack.peekLookAheadNonWhitespace: IElementType?
    get() {
        for (i in lookAheadBuffer.size - 1 downTo 0) {
            val tokenType = lookAheadBuffer[i]
            if (tokenType != TokenType.WHITE_SPACE) {
                return tokenType
            }
        }
        return null
    }

private inline val ParsingStack.peekLookAhead: IElementType?
    get() {
        return lookAheadBuffer.lastOrNull()
    }

private inline val ParsingStack.lastLookAhead: IElementType
    get() {
        return lookAheadBuffer.last()
    }

private val _NotedownLexer.beforeSequence: CharSequence
    get() {
        return this.zzBuffer.subSequence(0, zzStartRead)
    }

private fun _NotedownLexer.readAfter(): CharSequence {
    return this.zzBuffer.subSequence(0, zzEndRead)
}

// all whitespace until exhausted or until a newline is encountered
private fun _NotedownLexer.isStartOfHead(allowWhiteSpace: Boolean = true): Boolean {
    val chars = this.beforeSequence
    for (c in chars.reversed()) {
        if (c == '\n') {
            return true
        } else if (c == ' ' || c == '\t') {
            if (!allowWhiteSpace) {
                return false
            }
        } else {
            return false
        }
    }
    return true
}

private val _NotedownLexer.beforeCharacter: Char?
    get() {
        return this.beforeSequence.firstOrNull()
    }