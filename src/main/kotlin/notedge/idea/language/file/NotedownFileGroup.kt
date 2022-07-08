package notedge.idea.language.file

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider
import com.intellij.ide.projectView.ProjectViewNestingRulesProvider.Consumer

class NotedownFileGroup : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(consumer: Consumer) {
        consumer.addNestingRule(".note", ".html")
        consumer.addNestingRule(".note", ".tex")
    }
}