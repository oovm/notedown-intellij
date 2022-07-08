package notedge.idea.ide.matcher

import notedge.idea.language.psi.NoteTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class JssQuoteHandler : SimpleTokenSetQuoteHandler(NoteTypes.PARENTHESIS_L)
