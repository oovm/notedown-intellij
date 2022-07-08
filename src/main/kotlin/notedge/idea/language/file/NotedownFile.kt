package notedge.idea.language.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class NotedownFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, NotedownLanguage.INSTANCE) {
    override fun getFileType(): FileType = NotedownFileType.INSTANCE

    override fun toString(): String = NotedownBundle.message("action.create_file")
}