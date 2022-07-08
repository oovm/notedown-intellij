package notedge.idea.language.psi

import com.intellij.psi.tree.IElementType

class StackItem(val token: IElementType, val startOffset: Int, val endOffset: Int, val context: Int) {
    fun getState(): Int {
        return context
    }
}