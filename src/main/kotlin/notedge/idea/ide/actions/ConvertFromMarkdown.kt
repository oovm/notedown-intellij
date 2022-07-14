package notedge.idea.ide.actions

import notedge.idea.language.file.NotedownBundle
import notedge.idea.language.file.NotedownIcons
import com.intellij.ide.actions.CreateFileAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.psi.PsiFile

class ConvertFromMarkdown : CreateFileAction(name, description, NotedownIcons.FILE) {
    companion object {
        private val name = NotedownBundle.message("action.convert.from.markdown")
        private val description = NotedownBundle.message("action.convert.from.markdown.description")
    }

    private var sourceFile: PsiFile? = null;

    override fun update(event: AnActionEvent) {
        sourceFile = LangDataKeys.PSI_FILE.getData(event.dataContext)
        super.update(event)
    }
}