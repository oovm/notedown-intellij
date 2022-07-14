package notedge.idea.ide.matcher

import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import notedge.idea.language.ast.NRecursiveVisitor
import notedge.idea.language.psi.NoteParenthesis
import notedge.idea.language.psi.NoteXmlClosed
import notedge.idea.language.psi.NoteXmlFunction

class FoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : NRecursiveVisitor() {

    override fun visitParenthesis(o: NoteParenthesis) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitXmlFunction(o: NoteXmlFunction) {
        fold(o, o.xmlStart.namespace.endOffset, o.xmlEnd.lastChild.startOffset)
    }

    override fun visitXmlClosed(o: NoteXmlClosed) {
        fold(o, o.namespace.endOffset, o.lastChild.startOffset)
    }

    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }

    private fun fold(element: PsiElement, start: Int, end: Int) {
        if (start < end) {
            descriptors += FoldingDescriptor(element.node, TextRange.create(start, end))
        }
    }
}
