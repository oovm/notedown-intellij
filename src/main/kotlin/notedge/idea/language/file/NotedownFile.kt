package notedge.idea.language.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class NotedownFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, NotedownLanguage) {
    override fun getFileType(): FileType = NotedownFileType
}