package notedge.idea.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import notedge.idea.ide.view.NItemPresentation
import notedge.idea.language.ast.ViewNode
import notedge.idea.language.file.NotedownIcons
import notedge.idea.language.psi.NoteSnippet
import javax.swing.Icon


abstract class MixinSnippet(node: ASTNode) : ViewNode(node), NoteSnippet {
    override fun getIcon(flags: Int): Icon = NotedownIcons.CODE
    override fun getNavigationElement(): PsiElement {
        return this
    }

    override fun getPresentation(): ItemPresentation {
        return NItemPresentation(getIcon(0), this.navigationElement.text)
    }

    val snippetLevel: Int get() = this.firstChild.text.length

    fun isCodeBlock(): Boolean = when {
        snippetLevel < 3 -> false
        this.parent.children.count() == 1 -> true
        else -> false
    }
}