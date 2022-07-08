// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static notedge.idea.language.psi.NoteTypes.*;
import notedge.idea.language.ast.NotedownASTBase;
import notedge.idea.language.psi.*;

public class NoteTextElementsNode extends NotedownASTBase implements NoteTextElements {

  public NoteTextElementsNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NoteVisitor visitor) {
    visitor.visitTextElements(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NoteVisitor) accept((NoteVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<NoteBold> getBoldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteBold.class);
  }

  @Override
  @NotNull
  public List<NoteEscaped> getEscapedList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteEscaped.class);
  }

  @Override
  @NotNull
  public List<NoteItalic> getItalicList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteItalic.class);
  }

  @Override
  @NotNull
  public List<NoteItalicBold> getItalicBoldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteItalicBold.class);
  }

}