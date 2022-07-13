// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static notedge.idea.language.psi.NoteTypes.*;
import notedge.idea.language.mixin.MixinFunction;
import notedge.idea.language.psi.*;

public class NoteFunctionNode extends MixinFunction implements NoteFunction {

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
  @Nullable
  public NoteArgsBlock getArgsBlock() {
    return findChildByClass(NoteArgsBlock.class);
  }

  @Override
  @Nullable
  public NoteArgsFunction getArgsFunction() {
    return findChildByClass(NoteArgsFunction.class);
  }

  @Override
  @Nullable
  public NoteArgsText getArgsText() {
    return findChildByClass(NoteArgsText.class);
  }

  @Override
  @NotNull
  public NoteNamespace getNamespace() {
    return findNotNullChildByClass(NoteNamespace.class);
  }

}
