// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NoteXmlFunction extends PsiElement {

  @NotNull
  List<NoteHeader> getHeaderList();

  @NotNull
  List<NoteTextElements> getTextElementsList();

  @NotNull
  NoteXmlEnd getXmlEnd();

  @NotNull
  NoteXmlStart getXmlStart();

}
