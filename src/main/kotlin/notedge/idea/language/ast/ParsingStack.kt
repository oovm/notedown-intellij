package notedge.idea.language.ast

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import notedge.idea._NotedownLexer
import notedge.idea.language.psi.NoteTypes

private enum class StackItem {
    /// `code`
    Code,

    /// ``2`2``
    Code2,
    Italic,
    Bold,
    ItalicBold,
    StarUnknown,
    Underline,
    Strike,
    UnderlineItalic,
    HyphenUnknown
}

class ParsingStack {
    private var stack: MutableList<StackItem> = mutableListOf()

    private fun stackHas(item: StackItem): Boolean {
        return stack.contains(item)
    }

    fun analyzeHead(lexer: _NotedownLexer): IElementType {
        if (lexer.isStartOfHead()) {
            return NoteTypes.HEADER_HASH
        } else {
            return NoteTypes.TEXT
        }
    }

    fun analyzeCode(lexer: _NotedownLexer): IElementType {
//        if (stack.lastOrNull() == StackItem.Code) {
//            return NoteTypes.CODE
//        }
        return NoteTypes.ITALIC_L
    }

    fun analyzeStar(lexer: _NotedownLexer): IElementType {
        return NoteTypes.ITALIC_L
    }

    fun analyzeNewline(lexer: _NotedownLexer): IElementType {
        return TokenType.WHITE_SPACE
    }
}

fun _NotedownLexer.readBefore(): CharSequence {
    return this.zzBuffer.subSequence(0, zzStartRead)
}

fun _NotedownLexer.readAfter(): CharSequence {
    return this.zzBuffer.subSequence(0, zzEndRead)
}

// all whitespace until exhausted or until a newline is encountered
private fun _NotedownLexer.isStartOfHead(allowWhiteSpace: Boolean = true): Boolean {
    val chars = this.readBefore()
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