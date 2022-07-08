package notedge.idea.language.psi

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import notedge.idea._NotedownLexer

class ParsingStack {
    var stack: MutableList<ParsingStackItem> = mutableListOf()
    var asteriskStack: MutableList<Int> = mutableListOf()
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

    fun analyzeAsterisk(here: _NotedownLexer): IElementType {
        val last = asteriskStack.lastOrNull();
        val length = here.yylength()
        if (last == null || last > length) {
            when (length) {
                1 -> {
                    lookAheadBuffer.add(NoteTypes.ITALIC_L)
                }
                2 -> {
                    lookAheadBuffer.add(NoteTypes.BOLD_L)
                }
                3 -> {
                    lookAheadBuffer.add(NoteTypes.ITALIC_BOLD_L)
                }
                else -> {
                    lookAheadBuffer.add(NoteTypes.PLAIN_TEXT)
                    return lastLookAhead
                }
            }
            stack.add(ParsingStackItem.Asterisk(length))

        }
        // if (last == here.yylength())
        else {
            when (length) {
                1 -> {
                    asteriskStack.removeLast()
                    lookAheadBuffer.add(NoteTypes.ITALIC_R)
                }
                2 -> {
                    asteriskStack.removeLast()
                    lookAheadBuffer.add(NoteTypes.BOLD_R)
                }
                3 -> {
                    asteriskStack.removeLast()
                    lookAheadBuffer.add(NoteTypes.ITALIC_BOLD_R)
                }
                else -> TODO("unreachable")
            }
        }
        return lastLookAhead
    }

    fun analyzeTilde(here: _NotedownLexer): IElementType {
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
        when (peekLookAhead) {
            null, NoteTypes.NEW_LINE, NoteTypes.BREAK_PART -> {
                lookAheadBuffer.add(NoteTypes.BREAK_PART)
                return clearLookAhead
            }
            else -> {}
        }
        when {
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

private fun ParsingStack.stackHas(item: ParsingStackItem): Boolean {
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