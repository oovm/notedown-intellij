// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package notedge.idea.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import notedge.idea.language.psi_node.NoteSnippetNode

class SnippetAnnotator : Annotator {
    private fun validEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION).range(TextRange.from(offset, length)).textAttributes(VALID_STRING_ESCAPE)
            .create()
    }

    private fun uselessEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder.newSilentAnnotation(HighlightSeverity.WEAK_WARNING).range(TextRange.from(offset, length)).textAttributes(VALID_STRING_ESCAPE)
            .create()
    }

    private fun invalidEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder.newSilentAnnotation(HighlightSeverity.ERROR).range(TextRange.from(offset, length)).textAttributes(INVALID_STRING_ESCAPE).create()
    }

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is NoteSnippetNode -> check(element, holder)
            else -> return
        }
    }

    private fun check(element: NoteSnippetNode, holder: AnnotationHolder) {
        val text = element.text
        var offset = element.startOffset
        val end = element.endOffset
        while (offset < end) {
            when (text[offset]) {
                '\\' -> {
                    val next = text.getOrNull(offset + 1)
                    when {
                        next != '\\' -> {
                            uselessEscape(offset, 2, holder)
                        }
                        next == '$' -> {
                            invalidEscape(offset, 2, holder)
                        }
                        next == null -> {

                        }
                        else -> {
                            validEscape(offset, 2, holder)
                        }
                    }
                    offset += 2
                }
                else -> {
                    offset += 1
                }
            }
        }
    }
}

