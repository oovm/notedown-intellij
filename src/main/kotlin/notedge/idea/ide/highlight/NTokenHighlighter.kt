package notedge.idea.ide.highlight

import notedge.idea.language.psi.NLexerAdapter
import notedge.idea.language.psi.NoteTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import notedge.idea.ide.highlight.NotedownColor as Color

class NTokenHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return NLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): Color? {
        return when (tokenType) {
            //
            // AS, SCHEMA, PROP -> JssColor.KEYWORD
            HEADER_HASH -> Color.HEADER_MARK
            HEADER -> Color.HEADER_L1
            //
            PARENTHESIS_L, PARENTHESIS_R -> Color.PARENTHESES
            BRACKET_L, BRACKET_R -> Color.BRACKETS
            BRACE_L, BRACE_R -> Color.BRACES
            COLON, EQ -> Color.SET
            COMMA -> Color.COMMA
            // Style Marks
            ITALIC_L, ITALIC_R -> Color.ITALIC_MARK
            BOLD_L, BOLD_R -> Color.BOLD_MARK
            STRONG_L, STRONG_R -> Color.STRONG_MARK
            UNDER_L, UNDER_R -> Color.UNDERLINE_MARK
            WAVE_L, WAVE_R -> Color.WAVE_MARK
            STRIKE_L, STRIKE_R -> Color.STRIKE_MARK
            // atom
//            INTEGER -> JssColor.INTEGER
//            DECIMAL -> JssColor.DECIMAL
//            URL -> JssColor.URL
//            STRING -> JssColor.STRING
            SYMBOL -> Color.IDENTIFIER
            // 注释
//            COMMENT -> JssColor.LINE_COMMENT
//            COMMENT_BLOCK -> JssColor.BLOCK_COMMENT
//            COMMENT_DOCUMENT -> JssColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
            else -> null
        }
    }
}
