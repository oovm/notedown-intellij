package notedge.idea.language.ast

import com.intellij.psi.tree.IElementType
import notedge.idea.language.psi.NoteTypes
import java.util.*

class ParsingStack {
    enum class StackItem {
        /// `code`
        Code,

        /// *text*
        Italic,

        /// **text**
        Bold,

        /// ***text***
        ItalicBold,

        /// **********
        StarUnknown,

        /// _text_
        Underline,
        /// __text__
        Strike,
        /// ___text___
        UnderlineItalic,
        /// __________
        HyphenUnknown,
    }

    private var stack: MutableList<StackItem> = mutableListOf()

    private fun stackHas(item: StackItem): Boolean {
        return stack.contains(item)
    }

    fun analyzeCode(length: Int): IElementType {
//        if (stack.lastOrNull() == StackItem.Code) {
//            return NoteTypes.CODE
//        }
        return NoteTypes.ITALIC_L
    }

    fun analyzeStar(length: Int): IElementType {
        return NoteTypes.ITALIC_L
    }
}