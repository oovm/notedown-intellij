package notedge.idea.language.file

import com.intellij.icons.AllIcons
import com.intellij.openapi.util.IconLoader

object NotedownIcons {
    val FILE = IconLoader.getIcon("/icons/jssIcon.svg", NotedownIcons::class.java)
    val HEADER1 = IconLoader.getIcon("/icons/insightHotkey1.svg", NotedownIcons::class.java)
    val HEADER2 = IconLoader.getIcon("/icons/insightHotkey2.svg", NotedownIcons::class.java)
    val HEADER3 = IconLoader.getIcon("/icons/insightHotkey3.svg", NotedownIcons::class.java)
    val HEADER4 = IconLoader.getIcon("/icons/insightHotkey4.svg", NotedownIcons::class.java)
    val HEADER5 = IconLoader.getIcon("/icons/insightHotkey5.svg", NotedownIcons::class.java)
    val HEADER6 = IconLoader.getIcon("/icons/insightHotkey6.svg", NotedownIcons::class.java)
    val TEXT = IconLoader.getIcon("/icons/textArea.svg", NotedownIcons::class.java)
    val FUNCTION = AllIcons.Nodes.Function
    val COMPONENT = AllIcons.Nodes.Class
    val CODE = AllIcons.Actions.GroupByModule
    val CODE_BLOCK = AllIcons.Actions.GroupByModuleGroup

    val MATH = AllIcons.Actions.RegexSelected
    val ORDERED_LIST = AllIcons.Debugger.Db_array
    val RANDOM_LIST = AllIcons.General.MoreTabs
}