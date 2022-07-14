// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package notedge.idea.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.startOffset
import notedge.idea.language.ast.NotedownASTBase
import notedge.idea.language.psi_node.NoteCodeNode

class EscapeAnnotator : Annotator {
    fun validEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder
            .newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(TextRange.from(offset, length))
            .textAttributes(VALID_STRING_ESCAPE)
            .create()
    }

    /// Useless escaped character
    fun uselessEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder
            .newAnnotation(HighlightSeverity.WARNING, "Useless escaped character")
            .range(TextRange.from(offset, length))
            .textAttributes(VALID_STRING_ESCAPE)
            .create()
    }

    fun invalidEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder.newSilentAnnotation(HighlightSeverity.ERROR)
            .range(TextRange.from(offset, length))
            .textAttributes(INVALID_STRING_ESCAPE)
            .create()
    }

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is NoteCodeNode -> check(element, holder)
            else -> return
        }
    }

    private fun check(element: NoteCodeNode, holder: AnnotationHolder) {
        if (element.codeLevel != 1) {
            return
        }
        checkBase(element, holder)
    }
}

private fun EscapeAnnotator.checkBase(element: NotedownASTBase, holder: AnnotationHolder) {
    val text = element.text
    var offset = 0
    val end = element.text.length
    while (offset < end) {
        when (text.getOrNull(offset)) {
            '\\' -> {
                when (text.getOrNull(offset + 1)) {
                    '$', '"', '\'' -> {
                        uselessEscape(element.startOffset + offset, 2, holder)
                    }
                    null -> {
                        invalidEscape(element.startOffset + offset, 1, holder)
                    }
                    else -> {
                        validEscape(element.startOffset + offset, 2, holder)
                    }
                }
                offset += 2
            }
            null -> break
            else -> offset += 1
        }
    }
}

