package notedge.idea.ide.actions

import notedge.idea.language.file.NotedownBundle
import notedge.idea.language.file.NotedownIcons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class JssCreateFile :
    CreateFileFromTemplateAction(name, description, NotedownIcons.FILE) {
    companion object {
        private val name = NotedownBundle.message("action.create_file")
        private val description = NotedownBundle.message("action.create_file.description")
    }


    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder
            .setTitle(name)
            // See [resources/colors/fileTemplate]
            .addKind("Empty file", NotedownIcons.FILE, "Jss File")
    }


    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
