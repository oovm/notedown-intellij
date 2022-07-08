package notedge.idea.language.psi


import com.intellij.lexer.EmptyLexer
import com.intellij.lexer.LexerBase
import com.intellij.lexer.LookAheadLexer
import com.intellij.psi.tree.IElementType

// class NLexerAdapter : FlexAdapter(_NotedownLexer());


class LA: LookAheadLexer(EmptyLexer()) {

}

class NLexerAdapter : LexerBase() {
    private var buffer: CharSequence = ""
    private var startOffset: Int = 0
    private var endOffset: Int = 0
    private var stack: MutableList<StackItem> = mutableListOf()
    private var index: Int = 0
    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.stack = NTokenInterpreter(buffer, startOffset, endOffset, initialState).interpreter()
        this.index = 0
    }

    override fun getState(): Int = stack.getOrNull(index)?.getState() ?: 0
    override fun getTokenType(): IElementType? = stack.getOrNull(index)?.token
    override fun getTokenStart(): Int = stack.getOrNull(index)?.startOffset ?: startOffset
    override fun getTokenEnd(): Int = stack.getOrNull(index)?.endOffset ?: endOffset
    override fun advance() {
        index++
    }

    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset
}


