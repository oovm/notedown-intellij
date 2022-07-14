package notedge.idea.ide.doc

import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.richcopy.HtmlSyntaxInfoUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.ui.ColorUtil
import notedge.idea.ide.highlight.NotedownColor
import notedge.idea.language.file.NotedownLanguage
import notedge.idea.language.psi_node.NoteHeaderNode
import notedge.idea.language.psi_node.NoteIdentifierNode

class DocumentationRender(val element: PsiElement?) {
    private val s = StringBuilder()
    fun onGenerate(): String? {
        when (element) {
            null -> return null
            is NoteHeaderNode -> {
                renderDetail(element)
            }
            else -> {

            }
        }
        return s.toString()
    }

    fun onHover(): String? {
        when (element) {
            null -> return null
            else -> {}
        }
        return s.toString()
    }

    private fun renderDetail(element: NoteHeaderNode) {
        renderShort(element)
    }

    private fun renderShort(element: NoteHeaderNode) {
        append("function", NotedownColor.KEYWORD)
        appendSpace(1)
        append(element.headLevelName(), NotedownColor.SYM_FUNCTION)
        appendNewline()
        appendSpace(4)
        append("id", NotedownColor.SYM_ARGUMENT)
        append(":")
        appendSpace(1)
        append(element.headID(), NotedownColor.STRING)
    }


    private fun renderCode(element: PsiElement) {
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