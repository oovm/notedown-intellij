package notedge.idea.ide.codeStyle

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.psi.codeStyle.CodeStyleSettings

class CodeStyleAbstractConfigurable1(settings: CodeStyleSettings, modelSettings: CodeStyleSettings) :
    CodeStyleAbstractConfigurable(settings, modelSettings, "CodeStyleAbstractConfigurable1") {
    override fun createPanel(settings: CodeStyleSettings?): NCodeStyleMainPanel? {
        return settings?.let { NCodeStyleMainPanel(currentSettings, it) }
    }
}