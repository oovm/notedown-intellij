package notedge.idea.language.mixin

import com.intellij.lang.ASTNode
import notedge.idea.language.ast.NotedownNodeBase


class MixinHeader(node: ASTNode) : NotedownNodeBase(node) {
    fun getHeadLevel(): Int {
        return this.firstChild.text.takeWhile { it == '#' }.length
    }
}