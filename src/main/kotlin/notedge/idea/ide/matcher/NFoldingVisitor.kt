package notedge.idea.ide.matcher

import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.psi.PsiElement
import notedge.idea.language.psi.NRecursiveVisitor

class NFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : NRecursiveVisitor() {

//    override fun visitSchemaStatement(o: JssSchemaStatement) {
//        val block = o.childOfType<Br>()!!
//        fold(block)
//        super.visitSchemaStatement(o)
//    }

    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
}
