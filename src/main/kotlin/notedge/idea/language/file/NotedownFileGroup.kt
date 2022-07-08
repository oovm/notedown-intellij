package notedge.idea.language.file

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider
import org.jetbrains.annotations.NotNull

class NotedownFileGroup : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(@NotNull consumer: ProjectViewNestingRulesProvider.Consumer) {
        consumer.addNestingRule(".note", ".html")
        consumer.addNestingRule(".note", ".tex")
    }
}