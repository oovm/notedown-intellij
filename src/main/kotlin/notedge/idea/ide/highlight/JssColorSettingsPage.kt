package notedge.idea.ide.highlight

import notedge.idea.language.file.NotedownBundle
import notedge.idea.language.file.NotedownIcons
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class JssColorSettingsPage : ColorSettingsPage {
    private val annotatorTags = NotedownColor
        .values()
        .associateBy({ it.name }, { it.textAttributesKey })

    override fun getAttributeDescriptors() = NotedownColor
        .values()
        .map { it.attributesDescriptor }
        .toTypedArray()

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = NotedownBundle.message("filetype.name")

    override fun getIcon() = NotedownIcons.FILE

    override fun getHighlighter() = NTokenHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap() = annotatorTags

    override fun getDemoText() = javaClass.getResource("/messages/highlight.note")!!.readText()
}
