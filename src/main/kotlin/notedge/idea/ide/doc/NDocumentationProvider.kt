/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package notedge.idea.ide.doc

import com.intellij.codeInspection.actions.InspectionDescriptionDocumentationProvider
import com.intellij.codeInspection.ui.InspectionNodeInfo
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.util.elementType
import notedge.idea.language.file.NotedownFile
import notedge.idea.language.psi.NoteTypes

class NDocumentationProvider : InspectionDescriptionDocumentationProvider() {

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return DocumentationRender().onGenerate(element)
    }


    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
        return DocumentationRender().onHover(element)
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        return "<h1>generateRenderedDoc</h1>"
    }

    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return element?.let { this.generateHoverDoc(it, originalElement) }
    }

    override fun getCustomDocumentationElement(editor: Editor, file: PsiFile, contextElement: PsiElement?, targetOffset: Int): PsiElement? {
        if (file !is NotedownFile) return null
        return when (contextElement.elementType) {
            NoteTypes.SYMBOL -> {
                contextElement?.let { provideForSymbol(it) }
            }
            NoteTypes.BREAK_PART, WHITE_SPACE -> {
                null
            }
            else -> {
                print(contextElement.elementType)
                null
            }
        }
    }

    private fun provideForSymbol(element: PsiElement): PsiElement? {
        return element
    }
}