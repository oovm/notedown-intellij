package notedge.idea.ide.completion

import notedge.idea.language.psi.NoteTypes
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns

class CompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(NoteTypes.SYMBOL),
            SymbolCompletion()
        )
//        extend(
//            CompletionType.BASIC,
//            PlatformPatterns.psiElement(NoteTypes.ESCAPE),
//            SymbolCompletion()
//        )
    }
}

