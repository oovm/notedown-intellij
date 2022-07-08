package notedge.idea.language.psi

import com.intellij.lang.Language
import notedge.idea.language.file.NotedownLanguage
import com.intellij.psi.tree.IElementType

class NElementType(debugName: String) : IElementType(debugName, NotedownLanguage) {
    override fun toString(): String = "Notedown.${super.toString()}"
}
