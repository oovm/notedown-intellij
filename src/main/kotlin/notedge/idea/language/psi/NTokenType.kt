package notedge.idea.language.psi

import notedge.idea.language.file.NotedownLanguage
import com.intellij.psi.tree.IElementType

class NTokenType(debugName: String) : IElementType(debugName, NotedownLanguage) {
    override fun toString(): String = "Notedown.${super.toString()}"
}

