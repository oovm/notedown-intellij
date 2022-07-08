package notedge.idea.language.file

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object NotedownFileType: LanguageFileType(NotedownLanguage) {
    override fun getName(): String = NotedownBundle.message("filetype.name")

    override fun getDescription(): String = NotedownBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "jss"

    override fun getIcon(): Icon = NotedownIcons.FILE
}