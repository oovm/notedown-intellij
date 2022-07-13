// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NoteFunction extends PsiElement {

  @Nullable
  NoteArgsBlock getArgsBlock();

  @Nullable
  NoteArgsFunction getArgsFunction();

  @Nullable
  NoteArgsText getArgsText();

  @NotNull
  NoteNamespace getNamespace();

}
