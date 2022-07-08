package notedge.idea.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

open class NotedownNodeBase(node: ASTNode) : ASTWrapperPsiElement(node) {

}

open class ViewNode(node: ASTNode) : ASTWrapperPsiElement(node) {

}

open class DeclareNode(node: ASTNode) : ASTWrapperPsiElement(node) {

}