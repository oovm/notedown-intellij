package notedge.idea.ide.highlight

import notedge.idea.language.file.NotedownIcons
import com.intellij.openapi.options.colors.ColorDescriptor
import notedge.idea.language.file.NotedownLanguage

class ColorSettingsPage : com.intellij.openapi.options.colors.ColorSettingsPage {
    private val annotatorTags = NotedownColor
        .values()
        .associateBy({ it.name }, { it.textAttributesKey })

    override fun getAttributeDescriptors() = NotedownColor
        .values()
        .map { it.attributesDescriptor }
        .toTypedArray()

    /// inherit, no custom colors
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = NotedownLanguage.displayName

    override fun getIcon() = NotedownIcons.FILE

    override fun getHighlighter() = TokenHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap() = annotatorTags

    override fun getDemoText() = javaClass.getResource("/messages/highlight.note")!!.readText()
}
