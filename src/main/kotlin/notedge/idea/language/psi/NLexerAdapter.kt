package notedge.idea.language.psi


import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import notedge.idea._NotedownLexer

class NLexerAdapter : FlexAdapter(_NotedownLexer()) {

}

enum class LexerState {

}

class NLexerCustom : LexerBase() {

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        TODO("Not yet implemented")
    }

    override fun getState(): Int {
        TODO("Not yet implemented")
    }

    override fun getTokenType(): IElementType? {
        TODO("Not yet implemented")
    }

    override fun getTokenStart(): Int {
        TODO("Not yet implemented")
    }

    override fun getTokenEnd(): Int {
        TODO("Not yet implemented")
    }

    override fun advance() {
        TODO("Not yet implemented")
    }

    override fun getBufferSequence(): CharSequence {
        TODO("Not yet implemented")
    }

    override fun getBufferEnd(): Int {
        TODO("Not yet implemented")
    }

}