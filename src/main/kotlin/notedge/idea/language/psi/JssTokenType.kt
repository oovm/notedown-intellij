package notedge.idea.language.psi

import notedge.idea.language.file.NotedownLanguage
import com.intellij.psi.tree.IElementType

class JssTokenType(debugName: String) : IElementType(debugName, NotedownLanguage.INSTANCE) {
    override fun toString(): String = "JssTokenType.${super.toString()}"
}

