// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import notedge.idea.language.ast.NotedownNodeBase;
import notedge.idea.language.psi.*;

public class NoteFunctionNode extends NotedownNodeBase implements NoteFunction {

  public NoteFunctionNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NoteVisitor visitor) {
    visitor.visitFunction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NoteVisitor) accept((NoteVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public NoteNamespace getNamespace() {
    return findNotNullChildByClass(NoteNamespace.class);
  }

}
