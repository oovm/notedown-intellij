package notedge.idea.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import notedge.idea.ide.view.NItemPresentation
import notedge.idea.language.psi.startOffset
import javax.swing.Icon

abstract class NotedownNodeBase(node: ASTNode) : ASTWrapperPsiElement(node) {

}

open class ViewNode(node: ASTNode) : ASTWrapperPsiElement(node),
    NavigatablePsiElement {
    override fun getIcon(flags: Int): Icon;

    fun getDetail(): String? = null

    override fun getNavigationElement(): PsiElement;
    override fun getTextOffset(): Int = navigationElement.startOffset
    override fun getPresentation(): ItemPresentation {
        return NItemPresentation(getIcon(0), navigationElement.text, detail)
    }
}

open class DeclareNode(node: ASTNode) : ViewNode(node),
    PsiNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement;
    override fun getNavigationElement(): PsiElement = getNameIdentifier()
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}