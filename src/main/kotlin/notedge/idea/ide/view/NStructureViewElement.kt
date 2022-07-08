package notedge.idea.ide.view

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

class NStructureViewElement(private val node: NavigatablePsiElement) :
    StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any = node

    override fun navigate(requestFocus: Boolean) = node.navigate(requestFocus)

    override fun canNavigate(): Boolean = node.canNavigate()

    override fun canNavigateToSource(): Boolean = node.canNavigateToSource()

    override fun getAlphaSortKey(): String = node.name ?: ""

    override fun getPresentation(): ItemPresentation = node.presentation ?: PresentationData()

    override fun getChildren(): Array<out TreeElement> {
        // when (node) {
        //        is FluentFile -> getChildOfType(
        //            FluentMessageNode::class.java,
        //            FluentTermNode::class.java,
        //        )
        //        is FluentMessageNode, is FluentTermNode -> getChildOfType(
        //            FluentAttributeNode::class.java,
        //        )
        //        is FluentAttributeNode -> arrayOf()
        //        else -> getChildOfType(
        //            NavigatablePsiElement::class.java,
        //        )
        //    }
        return arrayOf()
    }

    private fun getChildOfType(vararg classes: Class<out NavigatablePsiElement>): Array<NStructureViewElement> {
        return PsiTreeUtil.getChildrenOfAnyType(node, *classes)
            .map { NStructureViewElement(it) }
            .toTypedArray()
    }
}

