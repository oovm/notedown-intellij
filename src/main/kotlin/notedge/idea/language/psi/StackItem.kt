package notedge.idea.language.psi

enum class StackItem {
    /// `code`
    Code,

    /// ``2`2``
    Code2,
    Italic,
    Bold,
    ItalicBold,
    StarUnknown,
    Underline,
    Strike,
    UnderlineItalic,
    HyphenUnknown
}