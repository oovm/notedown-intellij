package notedge.idea.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import notedge.idea.ide.view.NItemPresentation
import notedge.idea.ide.view.NStructureViewElement
import notedge.idea.language.ast.ViewNode
import notedge.idea.language.file.NotedownIcons
import notedge.idea.language.psi.NoteTextElements
import notedge.idea.language.psi_node.NoteCodeNode
import notedge.idea.language.psi_node.NoteFunctionNode
import notedge.idea.language.psi_node.NoteMathNode
import javax.swing.Icon


abstract class MixinTextElements(node: ASTNode) : ViewNode(node), NoteTextElements {
    override fun getIcon(flags: Int): Icon = NotedownIcons.TEXT
    override fun getNavigationElement(): PsiElement {
        return this
    }

    override fun getPresentation(): ItemPresentation {
        if (children.count() != 1) {
            return NItemPresentation(getIcon(0), null, this.text)
        }
        val child = children[0]
        return when {
            child is NoteFunctionNode -> {
                child.presentation
            }
            child is NoteMathNode && child.isDisplayBlock() -> {
                child.presentation
            }
            child is NoteCodeNode && child.isCodeBlock() -> {
                child.presentation
            }
            else -> {
                NItemPresentation(getIcon(0), "Paragraph")
            }
        }
    }

    override fun getChildrenView(): Array<NStructureViewElement> {
        return super.getChildrenView()
    }
}