package notedge.idea.language.ast

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import notedge.idea.ide.view.NItemPresentation
import notedge.idea.ide.view.NStructureViewElement

import javax.swing.Icon

abstract class ViewNode(node: ASTNode) : NotedownASTBase(node),
    NavigatablePsiElement {
    abstract override fun getIcon(flags: Int): Icon
    abstract override fun getNavigationElement(): PsiElement
    override fun getName(): String = navigationElement.text
    override fun getUserDataString(): String = ""
    override fun getTextOffset(): Int = navigationElement.textRange.startOffset
    override fun getPresentation(): ItemPresentation {
        return when (userDataString) {
            "" -> NItemPresentation(getIcon(0), name, null)
            else -> NItemPresentation(getIcon(0), name, userDataString)
        }
    }

    open fun getChildrenView(): Array<NStructureViewElement> = getChildOfType(ViewNode::class.java)

    fun getChildOfType(vararg classes: Class<out NavigatablePsiElement>): Array<NStructureViewElement> {
        return PsiTreeUtil.getChildrenOfAnyType(this, *classes)
            .map { NStructureViewElement(it) }
            .toTypedArray()
    }
}