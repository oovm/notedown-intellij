package notedge.idea.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import notedge.idea.ide.view.NItemPresentation
import notedge.idea.ide.view.NStructureViewElement
import notedge.idea.language.ast.ViewNode
import notedge.idea.language.file.NotedownIcons
import notedge.idea.language.psi.NoteHeader
import javax.swing.Icon


abstract class MixinHeader(node: ASTNode) : ViewNode(node), NoteHeader {
    override fun getIcon(flags: Int): Icon = NotedownIcons.HEADER
    override fun getNavigationElement(): PsiElement {
        return this.textElements
    }
    override fun getPresentation(): ItemPresentation {
        return NItemPresentation(getIcon(0), "H${headLevel}", this.textElements.text)
    }

    val headLevel: Int = this.firstChild.text.takeWhile { it == '#' }.length
}