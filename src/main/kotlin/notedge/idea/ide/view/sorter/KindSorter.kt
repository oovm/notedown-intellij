package notedge.idea.ide.view.sorter

import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.Sorter
import notedge.idea.language.file.NotedownBundle
import javax.swing.Icon

object KindSorter : Sorter {
    override fun getName(): String = "action.sorter.kind"
    override fun getPresentation(): ActionPresentation = object : ActionPresentation {
        override fun getText(): String = NotedownBundle.message(name)
        override fun getDescription(): String = ""
        override fun getIcon(): Icon = AllIcons.CodeWithMe.CwmPermissionEdit
    }

    override fun isVisible(): Boolean = true

    override fun getComparator(): Comparator<*> {
        TODO("Not yet implemented")
    }
}