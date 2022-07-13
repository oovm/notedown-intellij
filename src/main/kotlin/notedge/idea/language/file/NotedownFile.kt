package notedge.idea.language.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.util.PsiTreeUtil
import notedge.idea.ide.view.NStructureViewElement
import notedge.idea.language.ast.ViewNode
import notedge.idea.language.psi_node.NoteHeaderNode

class NotedownFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, NotedownLanguage) {
    override fun getFileType(): FileType = NotedownFileType

    fun getHeaders(): List<NoteHeaderNode> {
        return PsiTreeUtil.getChildrenOfAnyType(this, NoteHeaderNode::class.java)
    }

    fun getTopLevelHeaders(): List<NoteHeaderNode> {
        val headers = this.getHeaders();
        var top = 9;
        for (header in headers) {
            if (header.headLevel < top) {
                top = header.headLevel
            }
        }
        return headers.filter { it.headLevel == top }
    }

    fun getChildrenView(): Array<NStructureViewElement> {
        return PsiTreeUtil
            .getChildrenOfAnyType(this, ViewNode::class.java)
            .map { NStructureViewElement(it) }
            .toTypedArray()
    }
}