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

public class NoteXmlNode extends NotedownASTBase implements NoteXml {

  public NoteXmlNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NoteVisitor visitor) {
    visitor.visitXml(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NoteVisitor) accept((NoteVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<NoteCodeBlock> getCodeBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteCodeBlock.class);
  }

  @Override
  @NotNull
  public List<NoteFunction> getFunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteFunction.class);
  }

  @Override
  @NotNull
  public List<NoteHeader> getHeaderList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteHeader.class);
  }

  @Override
  @NotNull
  public List<NoteTextElements> getTextElementsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteTextElements.class);
  }

  @Override
  @NotNull
  public List<NoteXml> getXmlList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteXml.class);
  }

  @Override
  @Nullable
  public NoteXmlClose getXmlClose() {
    return findChildByClass(NoteXmlClose.class);
  }

  @Override
  @Nullable
  public NoteXmlEnd getXmlEnd() {
    return findChildByClass(NoteXmlEnd.class);
  }

  @Override
  @Nullable
  public NoteXmlStart getXmlStart() {
    return findChildByClass(NoteXmlStart.class);
  }

}
