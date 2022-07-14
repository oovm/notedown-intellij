// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NoteTextElements extends PsiElement {

  @NotNull
  List<NoteBold> getBoldList();

  @NotNull
  List<NoteCode> getCodeList();

  @NotNull
  List<NoteEscaped> getEscapedList();

  @NotNull
  List<NoteFunction> getFunctionList();

  @NotNull
  List<NoteItalic> getItalicList();

  @NotNull
  List<NoteMath> getMathList();

  @NotNull
  List<NoteStrike> getStrikeList();

  @NotNull
  List<NoteStrong> getStrongList();

  @NotNull
  List<NoteUnder> getUnderList();

  @NotNull
  List<NoteWave> getWaveList();

  @NotNull
  List<NoteXmlClosed> getXmlClosedList();

  @NotNull
  List<NoteXmlFunction> getXmlFunctionList();

}
