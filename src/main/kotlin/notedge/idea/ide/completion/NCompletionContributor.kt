package notedge.idea.ide.completion

import notedge.idea.language.psi.NoteTypes
import com.intellij.codeInsight.completion.*
import com.intellij.patterns.PlatformPatterns

class NCompletionContributor : CompletionContributor() {
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

