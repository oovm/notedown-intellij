package notedge.idea.ide.matcher

import notedge.idea.language.file.NotedownFile
import notedge.idea.language.psi.NoteTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class NFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(
        descriptors: MutableList<FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean
    ) {
        if (root !is NotedownFile) return
        val visitor = NFoldingVisitor(descriptors)
        PsiTreeUtil.processElements(root) {
            it.accept(visitor);
            true
        }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange) =
        when (node.elementType) {
            NoteTypes.BRACKET_BLOCK -> "[...]"
            NoteTypes.BRACE_BLOCK -> "{...}"
            else -> "..."
        }

    override fun isRegionCollapsedByDefault(node: ASTNode) = false
}
