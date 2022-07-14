package notedge.idea.ide.matcher

import notedge.idea.language.psi.NoteTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler
import com.intellij.openapi.editor.highlighter.HighlighterIterator

class QuoteHandler : SimpleTokenSetQuoteHandler(NoteTypes.STRING_TEXT) {

}
