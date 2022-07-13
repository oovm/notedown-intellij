package notedge.idea.ide.view.filter

import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import notedge.idea.language.file.NotedownBundle
import javax.swing.Icon

object CodeFilter : Filter {
    override fun getName(): String = "action.filter.code"
    override fun getPresentation(): ActionPresentation = object : ActionPresentation {
        override fun getText(): String = NotedownBundle.message(name)
        override fun getDescription(): String = ""
        override fun getIcon(): Icon = AllIcons.CodeWithMe.CwmPermissionEdit
    }
    override fun isVisible(treeNode: TreeElement?): Boolean {
        return true
    }
    override fun isReverted(): Boolean = false
}

