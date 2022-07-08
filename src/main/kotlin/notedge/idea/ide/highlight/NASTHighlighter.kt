package notedge.idea.ide.highlight

import notedge.idea.language.file.NotedownFile
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import notedge.idea.language.ast.NRecursiveVisitor
import notedge.idea.language.psi.NoteHeader
import notedge.idea.language.psi_node.NoteHeaderNode

class NASTHighlighter : NRecursiveVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitHeader(o: NoteHeader) {
        val node = o as NoteHeaderNode
        when (node.headLevel) {
            1 -> highlight(o, NotedownColor.HEADER_L1)
            2 -> highlight(o, NotedownColor.HEADER_L2)
            3 -> highlight(o, NotedownColor.HEADER_L3)
            4 -> highlight(o, NotedownColor.HEADER_L4)
            5 -> highlight(o, NotedownColor.HEADER_L5)
            else -> highlight(o, NotedownColor.HEADER_L6)
        }
    }



    private fun highlight(element: PsiElement, color: NotedownColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    override fun clone(): HighlightVisitor = NASTHighlighter()

    override fun suitableForFile(file: PsiFile): Boolean = file is NotedownFile

    override fun visit(element: PsiElement) = element.accept(this)
}