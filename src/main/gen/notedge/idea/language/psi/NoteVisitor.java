// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class NoteVisitor extends PsiElementVisitor {

  public void visitBraceBlock(@NotNull NoteBraceBlock o) {
    visitPsiElement(o);
  }

  public void visitBracketBlock(@NotNull NoteBracketBlock o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull NoteIdentifier o) {
    visitPsiElement(o);
  }

  public void visitItalic(@NotNull NoteItalic o) {
    visitPsiElement(o);
  }

  public void visitTextFunction(@NotNull NoteTextFunction o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
