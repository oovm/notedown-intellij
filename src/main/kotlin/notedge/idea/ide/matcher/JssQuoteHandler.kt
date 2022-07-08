package notedge.idea.ide.matcher

import notedge.idea.language.psi.JssTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class JssQuoteHandler : SimpleTokenSetQuoteHandler(JssTypes.STRING_INLINE)
