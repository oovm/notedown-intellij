package notedge.idea.ide.highlight

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.OptionsBundle
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts
import notedge.idea.language.file.NotedownBundle
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default
import com.intellij.openapi.editor.XmlHighlighterColors as XML


@Suppress("UnstableApiUsage")
enum class NotedownColor(
    humanName: Supplier<@NlsContexts.AttributeDescriptor String>,
    default: TextAttributesKey? = null,
) {
    // 特殊关键词
    KEYWORD(OptionsBundle.messagePointer("options.language.defaults.keyword"), Default.KEYWORD),
    IDIOM_SYMBOL(NotedownBundle.messagePointer("color.token.symbol.idiom"), Default.METADATA),
    IDIOM_MARK(NotedownBundle.messagePointer("color.token.idiom_mark"), IDIOM_SYMBOL.textAttributesKey),
    PROP_MARK(NotedownBundle.messagePointer("color.token.properties_mark"), KEYWORD.textAttributesKey),

    // 标题
    HEADER_MARK(NotedownBundle.messagePointer("color.token.header.mark"), XML.XML_ATTRIBUTE_NAME),
    HEADER_L1(NotedownBundle.messagePointer("color.token.header.level1"), HEADER_MARK.textAttributesKey),
    HEADER_L2(NotedownBundle.messagePointer("color.token.header.level2"), HEADER_MARK.textAttributesKey),
    HEADER_L3(NotedownBundle.messagePointer("color.token.header.level3"), HEADER_MARK.textAttributesKey),
    HEADER_L4(NotedownBundle.messagePointer("color.token.header.level4"), HEADER_MARK.textAttributesKey),
    HEADER_L5(NotedownBundle.messagePointer("color.token.header.level5"), HEADER_MARK.textAttributesKey),
    HEADER_L6(NotedownBundle.messagePointer("color.token.header.level6"), HEADER_MARK.textAttributesKey),

    // 字面量
    NULL(NotedownBundle.messagePointer("color.token.null"), Default.KEYWORD),
    BOOLEAN(NotedownBundle.messagePointer("color.token.boolean"), Default.KEYWORD),
    DECIMAL(NotedownBundle.messagePointer("color.token.decimal"), Default.NUMBER),
    INTEGER(NotedownBundle.messagePointer("color.token.integer"), Default.NUMBER),
    STRING(NotedownBundle.messagePointer("color.token.string"), Default.STRING),
    URL(NotedownBundle.messagePointer("color.token.url"), STRING.textAttributesKey),

    IDENTIFIER(OptionsBundle.messagePointer("options.language.defaults.identifier"), Default.IDENTIFIER),
    // 其他
    CODE_TEXT(NotedownBundle.messagePointer("color.token.code.text"), Default.MARKUP_ATTRIBUTE),
    CODE_MARK(NotedownBundle.messagePointer("color.token.code.mark"), CODE_TEXT.textAttributesKey),

    ITALIC_TEXT(NotedownBundle.messagePointer("color.token.italic.text"), Default.MARKUP_ATTRIBUTE),
    ITALIC_MARK(NotedownBundle.messagePointer("color.token.italic.mark"), ITALIC_TEXT.textAttributesKey),
    BOLD_TEXT(NotedownBundle.messagePointer("color.token.bold.text"), Default.MARKUP_ATTRIBUTE),
    BOLD_MARK(NotedownBundle.messagePointer("color.token.bold.mark"), BOLD_TEXT.textAttributesKey),
    STRONG_TEXT(NotedownBundle.messagePointer("color.token.strong.text"), Default.MARKUP_ATTRIBUTE),
    STRONG_MARK(NotedownBundle.messagePointer("color.token.strong.mark"), STRONG_TEXT.textAttributesKey),

    UNDERLINE_TEXT(NotedownBundle.messagePointer("color.token.underline.text"), Default.MARKUP_ATTRIBUTE),
    UNDERLINE_MARK(NotedownBundle.messagePointer("color.token.underline.mark"), UNDERLINE_TEXT.textAttributesKey),
    WAVE_TEXT(NotedownBundle.messagePointer("color.token.wave.text"), Default.MARKUP_ATTRIBUTE),
    WAVE_MARK(NotedownBundle.messagePointer("color.token.wave.mark"), WAVE_TEXT.textAttributesKey),
    STRIKE_TEXT(NotedownBundle.messagePointer("color.token.strike.text"), Default.MARKUP_ATTRIBUTE),
    STRIKE_MARK(NotedownBundle.messagePointer("color.token.strike.mark"), STRIKE_TEXT.textAttributesKey),




    //
    TYPE_HINT(NotedownBundle.messagePointer("color.token.symbol.type"), Default.CLASS_NAME),

    // 标点符号
    PARENTHESES(OptionsBundle.messagePointer("options.language.defaults.parentheses"), Default.PARENTHESES),
    BRACKETS(OptionsBundle.messagePointer("options.language.defaults.brackets"), Default.BRACKETS),
    BRACES(OptionsBundle.messagePointer("options.language.defaults.braces"), Default.BRACES),
    DOT(OptionsBundle.messagePointer("options.language.defaults.dot"), Default.DOT),
    COMMA(OptionsBundle.messagePointer("options.language.defaults.comma"), Default.COMMA),
    SET(NotedownBundle.messagePointer("color.token.set"), Default.OPERATION_SIGN),
    SEMICOLON(OptionsBundle.messagePointer("options.language.defaults.semicolon"), Default.SEMICOLON),

    // 注释
    LINE_COMMENT(OptionsBundle.messagePointer("options.language.defaults.line.comment"), Default.LINE_COMMENT),
    BLOCK_COMMENT(OptionsBundle.messagePointer("options.language.defaults.block.comment"), Default.BLOCK_COMMENT),
    DOC_COMMENT(OptionsBundle.messagePointer("options.language.defaults.doc.markup"), Default.DOC_COMMENT),

    // 错误
    BAD_CHARACTER(
        OptionsBundle.messagePointer("options.java.attribute.descriptor.bad.character"),
        HighlighterColors.BAD_CHARACTER
    ),

    // 废弃
    EXTENSION(OptionsBundle.messagePointer("options.language.defaults.metadata"), Default.METADATA),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("voml.lang.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}
