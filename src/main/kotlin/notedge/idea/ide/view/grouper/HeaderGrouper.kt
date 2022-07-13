package notedge.idea.ide.view.grouper

import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.Group
import com.intellij.ide.util.treeView.smartTree.Grouper
import com.intellij.ide.util.treeView.smartTree.TreeElement
import notedge.idea.language.file.NotedownBundle
import javax.swing.Icon

object HeaderGrouper : Grouper {
    override fun getName(): String = "action.grouper.header"
    override fun getPresentation(): ActionPresentation = object : ActionPresentation {
        override fun getText(): String = NotedownBundle.message(name)
        override fun getDescription(): String = ""
        override fun getIcon(): Icon = AllIcons.CodeWithMe.CwmPermissionEdit
    }

    override fun group(parent: AbstractTreeNode<*>, children: MutableCollection<TreeElement>):
            MutableCollection<Group> {
        TODO("Not yet implemented")
    }
}

