package notedge.idea.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import notedge.idea.ide.view.NItemPresentation
import notedge.idea.ide.view.NStructureViewElement
import notedge.idea.language.ast.ViewNode
import notedge.idea.language.file.NotedownIcons
import notedge.idea.language.psi.NoteFunction
import notedge.idea.language.psi.NoteHeader
import notedge.idea.language.psi.NoteXmlFunction
import javax.swing.Icon


abstract class MixinFunctionXML(node: ASTNode) : ViewNode(node), NoteXmlFunction {
    override fun getIcon(flags: Int): Icon = NotedownIcons.COMPONENT
    override fun getNavigationElement(): PsiElement {
        return this.xmlStart.namespace
    }

    override fun getChildrenView(): Array<NStructureViewElement> {
        return super.getChildrenView()
    }
}