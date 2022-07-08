// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import notedge.idea.language.ast.NotedownNodeBase;
import notedge.idea.language.psi.*;

public class NoteNamespaceNode extends NotedownNodeBase implements NoteNamespace {

  public NoteNamespaceNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NoteVisitor visitor) {
    visitor.visitNamespace(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NoteVisitor) accept((NoteVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<NoteIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NoteIdentifier.class);
  }

}
