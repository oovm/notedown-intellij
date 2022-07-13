package notedge.idea.ide.view.filter

import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import notedge.idea.ide.view.NStructureViewElement
import notedge.idea.language.file.NotedownBundle
import notedge.idea.language.file.NotedownIcons
import notedge.idea.language.psi_node.NoteHeaderNode
import javax.swing.Icon

object HeaderFilter : Filter {
    override fun getName(): String = "action.filter.header"
    override fun getPresentation(): ActionPresentation = object : ActionPresentation {
        override fun getText(): String = NotedownBundle.message(name)
        override fun getDescription(): String = ""
        override fun getIcon(): Icon = NotedownIcons.HEADER
    }
    override fun isVisible(treeNode: TreeElement?): Boolean {
        if (treeNode !is NStructureViewElement) return false
        return treeNode.value is NoteHeaderNode
    }
    override fun isReverted(): Boolean = false
}