package notedge.idea.ide.formatter

import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.tree.TokenSet
import notedge.idea.language.file.NotedownLanguage
import notedge.idea.language.psi.NoteTypes

data class FormatterContext(val commonSettings: CommonCodeStyleSettings, val spacingBuilder: SpacingBuilder) {
    companion object {
        fun create(settings: CodeStyleSettings): FormatterContext {
            val commonSettings = settings.getCommonSettings(NotedownLanguage)
            return FormatterContext(commonSettings, createSpacingBuilder(commonSettings))
        }

        private val remove_space_before = TokenSet.create(
            NoteTypes.PARENTHESIS_R,
            NoteTypes.BRACKET_R,
            NoteTypes.COMMA,
            NoteTypes.SEMICOLON
        )
        private val remove_space_after = TokenSet.create(
            NoteTypes.PARENTHESIS_L,
            NoteTypes.BRACKET_L,
            NoteTypes.COLON,
        )
        private val remove_space_newline_after = TokenSet.create()

        private val separators = TokenSet.create(NoteTypes.COMMA, NoteTypes.SEMICOLON)

        private fun createSpacingBuilder(commonSettings: CommonCodeStyleSettings): SpacingBuilder {
            val custom = SpacingBuilder(commonSettings)
                // ,
                .after(separators).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                // k: v
                .after(NoteTypes.COLON).spacing(1, 1, 0, false, 0)
                // k=v
                .around(NoteTypes.EQ).spacing(0, 0, 0, commonSettings.KEEP_LINE_BREAKS, 0)
            // SpacingBuilder { }
            // .before(NoteTypes.PROPERTIES_BLOCK).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)

            return custom
                .before(remove_space_before).spaceIf(false)
                .after(remove_space_after).spaceIf(false)
                .after(remove_space_newline_after).spacing(0, 0, 0, false, 0)
        }
    }
}