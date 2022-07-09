package notedge.idea.language.psi

import com.intellij.psi.tree.IElementType

@Suppress("MemberVisibilityCanBePrivate")
class StackItem(var token: IElementType, val startOffset: Int, val endOffset: Int, var context: Int) {

    constructor(token: IElementType, match: MatchResult, context: Int) : this(
        token,
        match.range.first,
        match.range.last + 1,
        context
    )


    fun getState(): Int {
        return context
    }

    override fun toString(): String {
        return "${token}[$startOffset-$endOffset]@${context}"
    }

    fun isSoftLeftMark(): Boolean? = when {
        softLeftMark.contains(this.token) -> true
        softRightMark.contains(this.token) -> false
        else -> null
    }


    fun isSoftRightMark(): Boolean? = when {
        softLeftMark.contains(this.token) -> false
        softRightMark.contains(this.token) -> true
        else -> null
    }

    fun IElementType.isHardLeftMark(): Boolean? = when (this) {

        else -> null
    }

    companion object {
        // 会被强制断行的元素
        val softLeftMark = setOf(
            NoteTypes.ITALIC_L, NoteTypes.BOLD_L, NoteTypes.STRONG_L,
            NoteTypes.UNDER_L, NoteTypes.WAVE_L, NoteTypes.STRIKE_L
        )
        val softRightMark = setOf(
            NoteTypes.ITALIC_R, NoteTypes.BOLD_R, NoteTypes.STRONG_R,
            NoteTypes.UNDER_R, NoteTypes.WAVE_R, NoteTypes.STRIKE_R
        )
    }
}