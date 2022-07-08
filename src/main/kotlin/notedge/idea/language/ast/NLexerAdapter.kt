package notedge.idea.language.ast


import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.psi.tree.IElementType
import notedge.idea._NotedownLexer

class NLexerAdapter : FlexAdapter(_NotedownLexer()) {

}
