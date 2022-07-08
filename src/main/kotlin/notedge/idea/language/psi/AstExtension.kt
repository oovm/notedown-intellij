package notedge.idea.language.psi

import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import notedge.idea.ide.formatter.FormatterContext


fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: FormatterContext): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}
