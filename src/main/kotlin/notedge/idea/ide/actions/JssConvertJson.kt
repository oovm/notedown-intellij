package notedge.idea.ide.actions

import notedge.idea.language.file.NotedownBundle
import notedge.idea.language.file.NotedownFileType
import notedge.idea.language.file.NotedownIcons
import com.intellij.ide.actions.CreateFileAction
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.application.WriteAction
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory

class JssConvertJson : CreateFileAction(name, description, NotedownIcons.FILE) {
    companion object {
        private val name = NotedownBundle.message("action.convert_json")
        private val description = NotedownBundle.message("action.convert_json.description")

    }

    private var sourceFile: PsiFile? = null;

    override fun update(event: AnActionEvent) {
        sourceFile = LangDataKeys.PSI_FILE.getData(event.dataContext)
        super.update(event)
    }
}