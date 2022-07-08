package notedge.idea.ide.file_view

import notedge.idea.language.file.NotedownBundle
import notedge.idea.language.file.NotedownLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class JssFileType private constructor() : LanguageFileType(NotedownLanguage.INSTANCE) {
    override fun getName(): String = NotedownBundle.message("filetype.name")

    override fun getDescription(): String = NotedownBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "jss"

    override fun getIcon(): Icon = JssIcons.FILE

    companion object {
        @JvmStatic
        val INSTANCE = JssFileType()
    }
}