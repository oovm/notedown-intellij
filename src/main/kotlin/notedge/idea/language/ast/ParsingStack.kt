package notedge.idea.language.ast

import java.util.*

class ParsingStack {
    enum class StackItem(val level: Int) {
        Italic(11),
        Bold(12),
        ItalicBold(13),
        StarUnknown(14),
    }
    private var stack: Stack<StackItem> = Stack()

    fun analize(item: StackItem) {
        stack.push(item)
    }

}