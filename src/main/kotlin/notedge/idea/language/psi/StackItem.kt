package notedge.idea.language.psi

import com.intellij.psi.tree.IElementType

@Suppress("MemberVisibilityCanBePrivate")
class StackItem {
    var token: IElementType
    val startOffset: Int
    val endOffset: Int
    var context: StackContext
    var paired: Boolean? = null

    constructor(token: IElementType, startOffset: Int, endOffset: Int, context: StackContext) {
        this.token = token
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.context = context
    }

    constructor(token: IElementType, match: MatchResult, context: StackContext, paired: Boolean? = null) {
        this.token = token
        this.startOffset = match.range.first
        this.endOffset =  match.range.last + 1
        this.context = context
        this.paired = paired
    }

    fun getState(): Int {
        return context.intoID()
    }

    override fun toString(): String {
        return "${token}[$startOffset-$endOffset]@${context}"
    }

    fun setPaired() {
        this.paired = true
    }

    fun setPlainText() {
        this.token = NoteTypes.PLAIN_TEXT;
        this.paired = null;
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