package notedge.idea.language.file

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object NotedownFileType : LanguageFileType(NotedownLanguage) {
    override fun getName(): String = NotedownLanguage.id
    override fun getDescription(): String = NotedownBundle.message("filetype.description")
    override fun getDisplayName(): String = NotedownLanguage.displayName
    override fun getDefaultExtension(): String = "note"
    override fun getIcon(): Icon = NotedownIcons.FILE
}