package notedge.idea.ide.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.Builder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import notedge.idea.language.file.NotedownBundle
import notedge.idea.language.file.NotedownIcons

class CreateNotedownFile : CreateFileFromTemplateAction(name, description, NotedownIcons.FILE) {
    companion object {
        private val name = NotedownBundle.message("action.create_file")
        private val description = NotedownBundle.message("action.create_file.description")
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder.setTitle(name)
            // See [resources/colors/fileTemplate]
            .addKind("Empty file", NotedownIcons.FILE, "Notedown File")
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
