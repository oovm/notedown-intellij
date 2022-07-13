package notedge.idea.ide.view

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import notedge.idea.language.ast.ViewNode
import notedge.idea.language.file.NotedownFile

class NStructureViewElement(val node: NavigatablePsiElement) : StructureViewTreeElement, SortableTreeElement {
    override fun getValue(): Any = node

    override fun navigate(requestFocus: Boolean) = node.navigate(requestFocus)

    override fun canNavigate(): Boolean = node.canNavigate()

    override fun canNavigateToSource(): Boolean = node.canNavigateToSource()

    override fun getAlphaSortKey(): String = node.name ?: ""

    override fun getPresentation(): ItemPresentation = node.presentation ?: PresentationData()

    override fun getChildren(): Array<out TreeElement> = when (node) {
        is NotedownFile -> node.getChildrenView()
        is ViewNode -> node.getChildrenView()
        else -> arrayOf()
    }
}

