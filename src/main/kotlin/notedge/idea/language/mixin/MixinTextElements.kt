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


abstract class MixinTextElements(node: ASTNode) : ViewNode(node), NoteHeader {
    override fun getIcon(flags: Int): Icon = NotedownIcons.TEXT
    override fun getNavigationElement(): PsiElement {
        return this
    }
    override fun getPresentation(): ItemPresentation {
        return NItemPresentation(getIcon(0), "Text", "${countCharacters()} characters")
    }

    fun countCharacters(): Int {
        return textElements.text.length
    }
}