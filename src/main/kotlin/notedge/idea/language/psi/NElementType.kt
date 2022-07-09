package notedge.idea.language.psi

import com.intellij.psi.tree.IElementType
import notedge.idea.language.file.NotedownLanguage

class NElementType(debugName: String) : IElementType(debugName, NotedownLanguage) {
    override fun toString(): String = "Notedown.${super.toString()}"
}

