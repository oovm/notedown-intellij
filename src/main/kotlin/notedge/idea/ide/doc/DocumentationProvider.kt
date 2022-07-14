/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package notedge.idea.ide.doc

import com.intellij.codeInspection.actions.InspectionDescriptionDocumentationProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.util.elementType
import notedge.idea.language.file.NotedownFile
import notedge.idea.language.psi.NoteTypes

class DocumentationProvider : InspectionDescriptionDocumentationProvider() {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return DocumentationRender(element).onGenerate()
    }
    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
        return DocumentationRender(element).onHover()
    }
    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        return "<h1>generateRenderedDoc</h1>"
    }
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return DocumentationRender(element).onHover()
    }
    override fun getCustomDocumentationElement(editor: Editor, file: PsiFile, contextElement: PsiElement?, targetOffset: Int): PsiElement? {
        if (file !is NotedownFile) return null
        return when (contextElement.elementType) {
            NoteTypes.SYMBOL -> {
                contextElement?.let { provideForSymbol(it) }
            }
            NoteTypes.DOT,
            NoteTypes.BREAK_PART, WHITE_SPACE -> {
                null
            }
            NoteTypes.HEADER_HASH -> {
                contextElement?.parent
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