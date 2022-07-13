package notedge.idea.ide.view.filter

import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import javax.swing.Icon

object CodeFilter: Filter {
    override fun getName(): String = "notedown.action.filter.code"

    override fun getPresentation(): ActionPresentation = object: ActionPresentation {
        override fun getText(): String {
            TODO("Not yet implemented")
        }
        override fun getDescription(): String {
            TODO("Not yet implemented")
        }
        override fun getIcon(): Icon {
            TODO("Not yet implemented")
        }
    }

    override fun isVisible(treeNode: TreeElement?): Boolean {
        return true
    }

    override fun isReverted(): Boolean = false

}