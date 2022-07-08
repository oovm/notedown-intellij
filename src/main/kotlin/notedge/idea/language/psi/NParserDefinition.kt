package notedge.idea.language.psi

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import notedge.idea.language.file.NotedownFile
import notedge.idea.language.file.NotedownLanguage
import notedge.idea.language.parser.NoteParser


object NParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = NLexerAdapter()

    override fun createParser(project: Project): PsiParser = NoteParser()

    override fun getFileNodeType(): IFileElementType = IFileElementType(NotedownLanguage)

    override fun getCommentTokens() = TokenSet.create()

    override fun getWhitespaceTokens() = TokenSet.create(TokenType.WHITE_SPACE, NoteTypes.NEW_LINE)

    override fun getStringLiteralElements() =TokenSet.create()

    override fun createElement(node: ASTNode): PsiElement = NoteTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = NotedownFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }
}
