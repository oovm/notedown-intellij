package notedge.idea.ide.view.grouper

import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.Group
import com.intellij.ide.util.treeView.smartTree.Grouper
import com.intellij.ide.util.treeView.smartTree.TreeElement

object HeaderGrouper: Grouper {
    override fun getPresentation(): ActionPresentation {
        TODO("Not yet implemented")
    }

    override fun getName(): String {
        TODO("Not yet implemented")
    }

    override fun group(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<TreeElement>
    ): MutableCollection<Group> {
        TODO("Not yet implemented")
    }
}