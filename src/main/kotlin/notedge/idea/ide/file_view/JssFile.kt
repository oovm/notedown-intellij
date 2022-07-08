package notedge.idea.ide.file_view

import notedge.idea.language.file.NotedownBundle
import notedge.idea.language.file.NotedownLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class JssFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, NotedownLanguage.INSTANCE) {
    override fun getFileType(): FileType = JssFileType.INSTANCE

    override fun toString(): String = NotedownBundle.message("action.create_file")
}