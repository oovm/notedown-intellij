// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static notedge.idea.language.psi.NoteTypes.*;
import notedge.idea.language.mixin.MixinTextElements;
import notedge.idea.language.psi.*;

public class NoteTextElementsNode extends MixinTextElements implements NoteTextElements {

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
  public List<NoteFunction> getFunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteFunction.class);
  }

  @Override
  @NotNull
  public List<NoteItalic> getItalicList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteItalic.class);
  }

  @Override
  @NotNull
  public List<NoteMath> getMathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteMath.class);
  }

  @Override
  @NotNull
  public List<NoteSnippet> getSnippetList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteSnippet.class);
  }

  @Override
  @NotNull
  public List<NoteStrike> getStrikeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteStrike.class);
  }

  @Override
  @NotNull
  public List<NoteStrong> getStrongList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteStrong.class);
  }

  @Override
  @NotNull
  public List<NoteUnder> getUnderList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteUnder.class);
  }

  @Override
  @NotNull
  public List<NoteWave> getWaveList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteWave.class);
  }

  @Override
  @NotNull
  public List<NoteXmlClosed> getXmlClosedList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteXmlClosed.class);
  }

  @Override
  @NotNull
  public List<NoteXmlFunction> getXmlFunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteXmlFunction.class);
  }

}
