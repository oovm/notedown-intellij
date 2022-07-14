package notedge.idea.ide.todo

import notedge.idea.language.psi.NLexerAdapter
import com.intellij.lexer.Lexer
import com.intellij.psi.impl.cache.impl.BaseFilterLexer
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer
import com.intellij.psi.impl.cache.impl.todo.LexerBasedTodoIndexer
import com.intellij.psi.search.UsageSearchContext
import notedge.idea.language.psi.NParserDefinition

class TodoIndexer : LexerBasedTodoIndexer() {
    override fun createLexer(consumer: OccurrenceConsumer): Lexer {
        return object : BaseFilterLexer(NLexerAdapter(), consumer) {
            override fun advance() {
                if (myDelegate.tokenType in NParserDefinition.commentTokens) {
                    scanWordsInToken(UsageSearchContext.IN_COMMENTS.toInt(), false, false)
                    advanceTodoItemCountsInToken()
                }
                myDelegate.advance()
            }
        }
    }
}
