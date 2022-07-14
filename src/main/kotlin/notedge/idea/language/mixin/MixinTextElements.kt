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
    private var isStandalone: Boolean = when {
        children.count() != 1 -> false
        else -> {
            val child = children[0]
            when {
                child is NoteFunctionNode -> true
                child is NoteMathNode && child.isDisplayBlock() -> true
                child is NoteCodeNode && child.isCodeBlock() -> true
                else -> false
            }
        }
    }


    override fun getIcon(flags: Int): Icon = NotedownIcons.TEXT
    override fun getNavigationElement(): PsiElement {
        return this
    }

    override fun getPresentation(): ItemPresentation = when {
        isStandalone -> {
            NItemPresentation(getIcon(0), null, this.text)
        }
        else -> {
            when (val child = children[0]) {
                is ViewNode -> child.presentation
                else -> NItemPresentation(getIcon(0), "Paragraph")
            }
        }
    }

    override fun getChildrenView(): Array<NStructureViewElement> = when {
        isStandalone -> {
            when (val child = children[0]) {
                is ViewNode -> child.getChildrenView()
                else -> arrayOf()
            }
        }
        else -> {
            when (val child = children[0]) {
                is ViewNode -> child.presentation
                else -> NItemPresentation(getIcon(0), "Paragraph")
            }
        }
    }
}