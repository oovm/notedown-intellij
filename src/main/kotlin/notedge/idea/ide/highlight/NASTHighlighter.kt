package notedge.idea.ide.highlight

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import notedge.idea.language.ast.NRecursiveVisitor
import notedge.idea.language.file.NotedownFile
import notedge.idea.language.psi.*
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


    override fun visitCodeInline(o: NoteCodeInline) {
        o.string?.let { highlight(it, NotedownColor.CODE_TEXT) }
    }

    override fun visitItalic(o: NoteItalic) {
        o.textElements?.let { highlight(it, NotedownColor.ITALIC_TEXT) }
    }

    override fun visitBold(o: NoteBold) {
        o.textElements?.let { highlight(it, NotedownColor.BOLD_TEXT) }
    }

    override fun visitStrong(o: NoteStrong) {
        o.textElements?.let { highlight(it, NotedownColor.STRONG_TEXT) }
    }

    override fun visitUnder(o: NoteUnder) {
        o.textElements?.let { highlight(it, NotedownColor.UNDERLINE_TEXT) }
    }

    override fun visitWave(o: NoteWave) {
        o.textElements?.let { highlight(it, NotedownColor.WAVE_TEXT) }
    }

    override fun visitStrike(o: NoteStrike) {
        o.textElements?.let { highlight(it, NotedownColor.STRIKE_TEXT) }
    }

    override fun visitFunction(o: NoteFunction) {
        highlight(o.namespace, NotedownColor.SYM_FUNCTION)
        highlight(o.firstChild, NotedownColor.SYM_FUNCTION)
        o.argsText?.let { highlight(it, NotedownColor.STRING) }
    }

    override fun visitArgument(o: NoteArgument) {
        o.key?.let { highlight(it, NotedownColor.SYM_ARGUMENT) }
        highlight(o.value.namespace, NotedownColor.SYM_VARIABLE)
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