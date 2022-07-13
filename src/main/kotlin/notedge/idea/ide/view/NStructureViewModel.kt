package notedge.idea.ide.view


import com.intellij.ide.structureView.StructureViewModel.ElementInfoProvider
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.Grouper
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import notedge.idea.ide.view.filter.CodeFilter
import notedge.idea.ide.view.filter.HeaderFilter
import notedge.idea.ide.view.grouper.HeaderGrouper
import notedge.idea.ide.view.sorter.KindSorter

class NStructureViewModel(psiFile: PsiFile?) :
    StructureViewModelBase(psiFile!!, NStructureViewElement(psiFile)),
    ElementInfoProvider {
    override fun getSorters(): Array<Sorter> = arrayOf(Sorter.ALPHA_SORTER, KindSorter)

    override fun getFilters(): Array<Filter> = arrayOf(HeaderFilter, CodeFilter)

    override fun getGroupers(): Array<Grouper> = arrayOf(HeaderGrouper)


    override fun isAlwaysShowsPlus(element: StructureViewTreeElement): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement): Boolean {
        return false
    }

    override fun isSuitable(element: PsiElement?): Boolean {
        return super.isSuitable(element)
    }
}

