package notedge.idea.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

abstract class DeclareNode(node: ASTNode) : ViewNode(node),
    PsiNameIdentifierOwner {
    abstract override fun getNameIdentifier(): PsiElement
    abstract override fun setName(name: String): PsiElement
    override fun getNavigationElement(): PsiElement = nameIdentifier
}