// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NoteXml extends PsiElement {

  @NotNull
  List<NoteCodeBlock> getCodeBlockList();

  @NotNull
  List<NoteFunction> getFunctionList();

  @NotNull
  List<NoteHeader> getHeaderList();

  @NotNull
  List<NoteTextElements> getTextElementsList();

  @NotNull
  List<NoteXml> getXmlList();

  @Nullable
  NoteXmlClose getXmlClose();

  @Nullable
  NoteXmlEnd getXmlEnd();

  @Nullable
  NoteXmlStart getXmlStart();

}
