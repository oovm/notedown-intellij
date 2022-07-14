package notedge.idea.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import notedge.idea.ide.view.NItemPresentation
import notedge.idea.ide.view.NStructureViewElement
import notedge.idea.language.ast.ViewNode
import notedge.idea.language.file.NotedownIcons
import notedge.idea.language.psi.NoteTextElements
import notedge.idea.language.psi_node.NoteCodeNode
import notedge.idea.language.psi_node.NoteFunctionNode
import notedge.idea.language.psi_node.NoteMathNode
import notedge.idea.language.psi_node.NoteXmlFunctionNode
import javax.swing.Icon


abstract class MixinTextElements(node: ASTNode) : ViewNode(node), NoteTextElements {
    private val viewNode: ViewNode?
        get() = when {
            children.count() != 1 -> null
            else -> {
                val child = children[0]
                when {
                    child is NoteFunctionNode -> child
                    child is NoteXmlFunctionNode -> child
                    child is NoteMathNode && child.isDisplayBlock() -> child
                    child is NoteCodeNode && child.isCodeBlock() -> child
                    else -> null
                }
            }
        }

    override fun getIcon(flags: Int): Icon = NotedownIcons.TEXT
    override fun getNavigationElement(): PsiElement {
        return this
    }

    override fun getPresentation(): ItemPresentation = when (viewNode) {
        null -> {
            NItemPresentation(getIcon(0), null, this.text)
        }
        else -> {
            viewNode!!.presentation
        }
    }

    override fun getChildrenView(): Array<NStructureViewElement> = when (viewNode) {
        null -> {
            getChildOfType(NavigatablePsiElement::class.java)
        }
        else -> {
            viewNode!!.getChildrenView()
        }
    }
}