package notedge.idea.ide.codeStyle

import com.intellij.application.options.SmartIndentOptionsEditor
import com.intellij.psi.codeStyle.*
import com.intellij.psi.codeStyle.CommonCodeStyleSettings.IndentOptions
import notedge.idea.language.file.NotedownLanguage

class NLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider() {
    override fun getLanguage() = NotedownLanguage

    override fun getIndentOptionsEditor() = SmartIndentOptionsEditor()

    override fun createConfigurable(settings: CodeStyleSettings, modelSettings: CodeStyleSettings, ): CodeStyleConfigurable {
        return CodeStyleAbstractConfigurable1(settings, modelSettings)
    }

    override fun customizeSettings(consumer: CodeStyleSettingsCustomizable, settingsType: SettingsType) {
        when (settingsType) {
            SettingsType.COMMENTER_SETTINGS -> {
                consumer.showStandardOptions(
                    CodeStyleSettingsCustomizable.CommenterOption.BLOCK_COMMENT_AT_FIRST_COLUMN.name,
                    CodeStyleSettingsCustomizable.CommenterOption.LINE_COMMENT_ADD_SPACE.name,
                    CodeStyleSettingsCustomizable.CommenterOption.LINE_COMMENT_AT_FIRST_COLUMN.name
                )
            }
            SettingsType.WRAPPING_AND_BRACES_SETTINGS -> {
                consumer.showStandardOptions(
                    CodeStyleSettingsCustomizable.WrappingOrBraceOption.RIGHT_MARGIN.name,
                    CodeStyleSettingsCustomizable.WrappingOrBraceOption.KEEP_LINE_BREAKS.name
                )
            }
            SettingsType.LANGUAGE_SPECIFIC -> {
                consumer.showStandardOptions()
            }
            else -> {}
        }
    }

    override fun customizeDefaults(commonSettings: CommonCodeStyleSettings, indentOptions: IndentOptions) {
        commonSettings.RIGHT_MARGIN = DEFAULT_RIGHT_MARGIN

        commonSettings.LINE_COMMENT_AT_FIRST_COLUMN = false
        commonSettings.LINE_COMMENT_ADD_SPACE = true
        commonSettings.BLOCK_COMMENT_AT_FIRST_COLUMN = false

        indentOptions.CONTINUATION_INDENT_SIZE = indentOptions.INDENT_SIZE
    }

    override fun getCodeSample(settingsType: SettingsType) = javaClass.getResource("/messages/code_style.note")!!.readText()

    companion object {
        const val DEFAULT_RIGHT_MARGIN = 100
    }
}

