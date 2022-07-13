package notedge.idea.language.ast

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import notedge.idea.ide.view.NItemPresentation
import notedge.idea.ide.view.NStructureViewElement
import notedge.idea.language.psi.startOffset
import javax.swing.Icon

abstract class ViewNode(node: ASTNode) : NotedownASTBase(node),
    NavigatablePsiElement {
    abstract override fun getIcon(flags: Int): Icon;
    abstract override fun getNavigationElement(): PsiElement;
    override fun getName(): String = navigationElement.text
    open fun getDetailText(): String? = null
    override fun getTextOffset(): Int = navigationElement.startOffset
    override fun getPresentation(): ItemPresentation {
        return NItemPresentation(getIcon(0), name, getDetailText())
    }
    open fun getChildrenView(): Array<NStructureViewElement> = arrayOf()

    fun getChildOfType(vararg classes: Class<out NavigatablePsiElement>): Array<NStructureViewElement> {
        return PsiTreeUtil.getChildrenOfAnyType(this, *classes)
            .map { NStructureViewElement(it) }
            .toTypedArray()
    }
}