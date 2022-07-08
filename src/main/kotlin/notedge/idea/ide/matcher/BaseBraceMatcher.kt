package notedge.idea.ide.matcher

import notedge.idea.language.psi.NoteTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import notedge.idea.language.psi.NParserDefinition

class BaseBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, next: IElementType?): Boolean {
        return next in InsertPairBraceBefore
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset

    companion object {
        private val PAIRS = arrayOf(
            BracePair(NoteTypes.BRACE_L, NoteTypes.BRACE_R, true),
            BracePair(NoteTypes.BRACKET_L, NoteTypes.BRACKET_R, true),
            BracePair(NoteTypes.PARENTHESIS_L, NoteTypes.PARENTHESIS_R, true),
            // BracePair(VomlTypes.EXT_PREFIX, VomlTypes.BRACKETR, false)
        )

        private val InsertPairBraceBefore = TokenSet.orSet(
            NParserDefinition.COMMENTS,
            TokenSet.create(
                TokenType.WHITE_SPACE,
                NoteTypes.COMMA,
                NoteTypes.PARENTHESIS_R,
                NoteTypes.BRACKET_R,
                NoteTypes.BRACE_R,
            )
        )
    }
}
