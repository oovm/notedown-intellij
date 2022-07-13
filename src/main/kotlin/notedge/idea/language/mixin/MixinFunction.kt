package notedge.idea.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import notedge.idea.ide.view.NItemPresentation
import notedge.idea.ide.view.NStructureViewElement
import notedge.idea.language.ast.ViewNode
import notedge.idea.language.file.NotedownIcons
import notedge.idea.language.psi.NoteFunction
import notedge.idea.language.psi.NoteHeader
import javax.swing.Icon


abstract class MixinFunction(node: ASTNode) : ViewNode(node), NoteFunction {
    override fun getIcon(flags: Int): Icon = NotedownIcons.FUNCTION
    override fun getNavigationElement(): PsiElement {
        return this.namespace
    }
    override fun getPresentation(): ItemPresentation {
        return NItemPresentation(getIcon(0), this.navigationElement.text)
    }

}