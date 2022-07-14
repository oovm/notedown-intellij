package notedge.idea.ide.doc

import com.intellij.ide.favoritesTreeView.NoteNode
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.richcopy.HtmlSyntaxInfoUtil
import com.intellij.psi.PsiElement
import com.intellij.ui.ColorUtil
import notedge.idea.ide.highlight.NotedownColor
import notedge.idea.language.file.NotedownLanguage

class DocumentationRender() {
    private val s = StringBuilder()
    fun onGenerate(element: PsiElement): String {
        HtmlSyntaxInfoUtil.appendHighlightedByLexerAndEncodedAsHtmlCodeSnippet(
            s,
            element.project,
            NotedownLanguage,
            element.text,
            1.0f,
        )
        return s.toString()
    }

    fun onHover(element: PsiElement): String {
        when (element) {

        }


        HtmlSyntaxInfoUtil.appendHighlightedByLexerAndEncodedAsHtmlCodeSnippet(
            s,
            element.project,
            NotedownLanguage,
            element.text,
            1.0f,
        )
        return s.toString()
    }

    private renderShort(element: PsiElement) {
        s.append("<span style=\"color: ")
        s.append(ColorUtil.toHex(EditorColorsManager.getInstance().globalScheme.getColor(NotedownColor.SHORT_NAME)))
        s.append(";\">")
        s.append(element.text)
        s.append("</span>")
    }

    private renderCode(element: PsiElement) {
        HtmlSyntaxInfoUtil.appendHighlightedByLexerAndEncodedAsHtmlCodeSnippet(
            s,
            element.project,
            NotedownLanguage,
            element.text,
            1.0f,
        )
    }

    private fun append(text: String, color: NotedownColor) {
        // HtmlSyntaxInfoUtil.getStyledSpan(key.textAttributesKey, text, 1.0f)
        val attr = EditorColorsManager.getInstance().globalScheme.getAttributes(color.textAttributesKey)
        val hex = ColorUtil.toHtmlColor(attr.foregroundColor)
        s.append("<span style='color:${hex}'>${text}</span>")
    }

    private fun append(text: String) {
        s.append("<span>${text}</span>")
    }

    private fun appendNewline() {
        s.append("<br>")
    }

    private fun appendSpace(length: Int = 4) {
        for (i in 0 until length) {
            s.append("&nbsp;")
        }
    }
}