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

public class NoteXmlFunctionNode extends NotedownASTBase implements NoteXmlFunction {

  public NoteXmlFunctionNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NoteVisitor visitor) {
    visitor.visitXmlFunction(this);
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
  public NoteXmlEnd getXmlEnd() {
    return findNotNullChildByClass(NoteXmlEnd.class);
  }

  @Override
  @NotNull
  public NoteXmlStart getXmlStart() {
    return findNotNullChildByClass(NoteXmlStart.class);
  }

}
