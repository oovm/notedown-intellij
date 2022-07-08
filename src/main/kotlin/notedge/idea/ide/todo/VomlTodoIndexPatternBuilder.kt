package notedge.idea.ide.todo

import notedge.idea.language.psi.NLexerAdapter
import notedge.idea.language.file.NotedownFile
import notedge.idea.language.psi.JSS_COMMENT
import com.intellij.lexer.Lexer
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.search.IndexPatternBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class VomlTodoIndexPatternBuilder : IndexPatternBuilder {
    override fun getIndexingLexer(file: PsiFile): Lexer? {
        return if (file is NotedownFile) NLexerAdapter() else null
    }

    override fun getCommentTokenSet(file: PsiFile): TokenSet? {
        return if (file is NotedownFile) JSS_COMMENT else null
    }

    override fun getCommentStartDelta(tokenType: IElementType?): Int {
        return if (tokenType in JSS_COMMENT) 2 else 0
    }

    override fun getCommentEndDelta(tokenType: IElementType?): Int = 0
}
