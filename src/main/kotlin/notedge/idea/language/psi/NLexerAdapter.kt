package notedge.idea.language.psi


import com.intellij.lexer.FlexAdapter
import notedge.idea._NotedownLexer

class NLexerAdapter : FlexAdapter(_NotedownLexer())
