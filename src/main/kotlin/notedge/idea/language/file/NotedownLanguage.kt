package notedge.idea.language.file

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType

object NotedownLanguage : Language("Notedown") {
    const val BUNDLE = "messages.NotedownBundle"
    override fun getAssociatedFileType(): LanguageFileType = NotedownFileType
    override fun getMimeTypes(): Array<String> = arrayOf("text/notedown")
    override fun getDisplayName(): String = NotedownBundle.message("filetype.name")
}


