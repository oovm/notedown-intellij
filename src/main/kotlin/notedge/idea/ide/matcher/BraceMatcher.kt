package notedge.idea.ide.matcher

import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.fileTypes.FileType
import notedge.idea.language.file.NotedownFileType
import notedge.idea.language.file.NotedownLanguage

class BraceMatcher : PairedBraceMatcherAdapter(BraceMatcherBase(), NotedownLanguage) {
    override fun isLBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean {
        return isBrace(iterator, fileText, fileType, true)
    }

    override fun isRBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean {
        return isBrace(iterator, fileText, fileType, false)
    }

    private fun isBrace(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType, left: Boolean): Boolean {
        if (fileType != NotedownFileType) return false
        val pair = findPair(left, iterator, fileText, fileType)
        return pair != null
    }
}
