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

public class NoteXmlClosedNode extends NotedownASTBase implements NoteXmlClosed {

  public NoteXmlClosedNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NoteVisitor visitor) {
    visitor.visitXmlClosed(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NoteVisitor) accept((NoteVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<NoteArgument> getArgumentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteArgument.class);
  }

  @Override
  @NotNull
  public NoteNamespace getNamespace() {
    return findNotNullChildByClass(NoteNamespace.class);
  }

}