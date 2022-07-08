/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package notedge.idea;

import com.intellij.lexer.FlexLexer;
import notedge.idea.language.psi.ParsingStack;

import com.intellij.psi.tree.IElementType;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static notedge.idea.language.psi.NoteTypes.*;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Notedown.flex</tt>
 */
public class _NotedownLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int CodeFragment = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [12, 6, 3]
   * Total runtime size is 16832 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>9]<<6)|((ch>>3)&0x3f)]<<3)|(ch&0x7)];
  }

  /* The ZZ_CMAP_Z table has 2176 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
    "\20\5\21\1\22\1\21\1\23\1\21\14\24\1\25\50\24\1\26\2\24\1\27\1\30\1\31\1\32"+
    "\25\24\1\33\20\21\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1"+
    "\21\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\21\1\24\1\56\1\57\5\21\2\24\1\60"+
    "\7\21\1\24\1\61\20\21\1\24\1\62\1\21\1\63\13\24\1\64\1\24\1\65\22\21\1\66"+
    "\5\21\1\67\11\21\1\70\1\71\1\72\1\73\1\21\1\74\2\21\1\75\3\21\1\76\2\21\1"+
    "\77\10\21\123\24\1\100\7\24\1\101\1\102\12\24\1\103\24\21\1\24\1\104\u0582"+
    "\21\1\105\u017f\21");

  /* The ZZ_CMAP_Y table has 4480 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\2\0\1\2\1\3\1\4\1\5\1\6\2\7\1\10\1\6\2\7\1\11\1\12\3\0\1\13\1\14"+
    "\1\15\1\14\2\7\1\16\3\7\1\16\71\7\1\17\1\7\1\20\1\0\1\21\1\22\2\0\16\4\1\23"+
    "\1\24\1\25\1\26\2\7\1\27\11\7\1\30\21\7\1\31\1\32\24\7\1\6\3\7\1\16\1\33\1"+
    "\6\4\7\1\0\1\34\4\4\1\35\1\36\1\0\3\7\2\11\3\0\1\4\1\37\5\7\1\40\3\4\1\41"+
    "\1\42\13\7\1\43\1\44\1\45\1\46\1\4\1\47\2\0\1\50\3\7\3\4\1\51\12\7\1\52\1"+
    "\4\1\53\1\0\1\4\1\54\3\7\1\40\1\55\1\14\2\7\1\52\1\56\1\57\1\60\2\0\3\7\1"+
    "\61\10\0\2\7\1\23\1\62\2\0\1\63\1\4\1\64\3\4\1\65\6\7\1\66\2\4\1\67\1\7\1"+
    "\70\1\4\1\6\1\7\1\71\1\72\1\73\2\7\1\74\1\75\1\76\1\44\1\77\1\100\1\101\1"+
    "\70\1\4\1\20\1\0\1\102\1\103\1\73\2\7\1\74\1\104\1\105\1\106\1\107\1\110\1"+
    "\111\1\112\1\4\1\113\1\0\1\102\1\30\1\27\2\7\1\74\1\114\1\76\1\35\1\115\1"+
    "\116\1\0\1\70\1\4\1\0\1\33\1\102\1\72\1\73\2\7\1\74\1\114\1\76\1\44\1\107"+
    "\1\112\1\101\1\70\1\4\1\33\1\0\1\117\1\120\1\121\1\122\1\123\1\120\1\7\1\124"+
    "\1\125\1\126\1\127\1\0\1\112\1\4\2\0\1\130\1\23\1\74\2\7\1\74\1\7\1\131\1"+
    "\132\1\126\1\133\1\11\1\70\1\4\2\0\1\71\1\23\1\74\2\7\1\74\1\134\1\76\1\132"+
    "\1\126\1\133\1\135\1\70\1\4\1\136\1\0\1\102\1\23\1\74\4\7\1\137\1\132\1\140"+
    "\1\141\1\142\1\70\1\4\1\0\1\32\1\143\1\7\1\16\1\32\2\7\1\27\1\144\1\16\1\145"+
    "\1\146\1\4\1\112\1\4\1\147\1\0\1\6\5\7\1\150\1\37\1\151\1\152\1\4\1\5\4\0"+
    "\1\153\1\154\1\155\1\6\1\156\1\157\1\150\1\160\1\161\1\162\1\4\1\163\4\0\1"+
    "\116\2\0\1\5\1\4\1\5\1\164\1\165\1\7\1\6\3\7\1\21\1\34\1\4\1\132\1\166\1\4"+
    "\1\34\3\4\1\167\1\170\7\0\5\7\1\40\1\4\1\171\1\4\1\5\1\52\1\172\1\173\1\174"+
    "\1\175\1\7\1\176\1\177\1\4\1\162\4\7\1\30\1\200\5\7\1\201\51\7\1\121\1\16"+
    "\1\121\5\7\1\121\4\7\1\121\1\16\1\121\1\7\1\16\7\7\1\121\10\7\1\202\1\0\1"+
    "\34\1\5\1\0\2\7\2\0\12\7\2\62\1\6\114\7\1\72\2\7\1\203\2\7\1\11\11\7\1\120"+
    "\1\7\1\116\1\7\1\23\1\204\1\0\2\7\1\204\1\0\2\7\1\205\1\0\1\7\1\23\1\206\1"+
    "\0\6\7\1\207\3\4\1\210\1\211\1\4\1\5\3\0\1\212\1\4\1\5\13\7\1\0\5\7\1\213"+
    "\10\7\1\62\1\0\3\7\1\16\1\4\1\214\1\4\1\214\1\112\1\4\3\7\1\62\1\21\1\0\5"+
    "\7\1\215\3\7\1\20\1\4\1\37\4\0\2\7\1\151\1\214\6\7\1\166\1\152\3\4\1\44\1"+
    "\4\1\5\1\4\1\5\1\142\1\0\1\4\1\162\10\0\1\216\5\7\1\207\1\4\1\216\1\215\1"+
    "\4\1\5\1\0\1\217\1\214\1\0\1\220\3\7\1\67\1\174\1\4\1\54\4\7\1\52\1\4\1\214"+
    "\1\0\4\7\1\207\2\4\1\0\1\4\1\221\1\4\1\54\3\7\1\62\1\7\1\116\10\0\1\222\2"+
    "\4\1\223\1\224\1\5\30\7\6\4\1\162\1\217\42\7\2\62\4\7\2\62\1\7\1\225\3\7\1"+
    "\62\6\7\1\23\1\161\1\226\1\21\1\227\1\215\1\7\1\21\1\226\1\21\1\230\1\231"+
    "\3\0\1\232\1\0\1\100\1\233\1\0\1\234\1\235\2\0\1\33\1\142\2\0\1\7\1\21\6\0"+
    "\1\4\1\167\1\236\1\4\1\233\1\0\1\237\1\32\1\144\1\62\1\22\1\74\1\7\1\240\1"+
    "\241\1\242\2\0\5\7\1\116\116\0\5\7\1\16\5\7\1\16\20\7\1\21\1\243\1\244\1\0"+
    "\4\7\1\30\1\200\7\7\1\142\1\0\1\100\2\7\1\16\1\0\10\16\4\4\1\245\3\0\1\6\1"+
    "\176\1\246\1\21\1\6\11\7\1\16\1\247\1\6\12\7\1\201\1\241\4\7\1\62\1\6\12\7"+
    "\1\16\2\0\3\7\1\11\6\0\170\7\1\62\11\0\72\7\1\62\5\0\21\7\1\21\10\0\5\7\1"+
    "\62\41\7\1\21\2\7\1\4\1\244\2\0\5\7\1\151\1\63\1\250\3\7\1\52\12\7\1\5\3\0"+
    "\1\142\1\7\1\32\14\7\1\73\3\7\1\16\1\7\7\0\1\142\1\7\1\251\1\252\2\7\1\40"+
    "\3\0\6\7\1\215\1\0\1\54\5\7\1\207\1\4\1\162\1\0\1\4\1\5\2\4\1\54\1\253\1\4"+
    "\1\54\2\7\1\52\1\162\2\7\1\151\1\4\1\214\1\0\3\7\1\21\1\65\5\7\1\40\1\4\1"+
    "\233\1\142\1\4\1\5\1\254\1\7\1\4\1\255\5\7\1\67\1\152\1\0\1\252\1\256\1\4"+
    "\1\5\2\7\1\16\1\257\6\7\1\173\1\260\1\213\2\0\1\261\1\7\1\40\1\262\1\0\3\263"+
    "\1\0\2\16\5\7\1\201\1\62\1\0\16\7\1\40\1\264\1\4\1\5\64\7\1\215\1\0\2\7\1"+
    "\16\1\265\5\7\1\215\40\0\55\7\1\62\15\7\1\20\4\0\1\16\1\0\1\265\1\266\1\7"+
    "\1\74\1\16\1\161\1\267\15\7\1\20\3\0\1\265\20\7\1\62\1\155\32\7\1\62\2\0\10"+
    "\7\1\32\6\7\5\0\1\7\1\20\2\4\2\0\2\4\1\270\2\0\1\271\4\0\1\272\1\225\17\7"+
    "\1\21\2\0\1\4\1\5\1\6\2\7\1\273\1\6\2\7\1\11\1\274\6\7\1\52\3\7\1\16\3\32"+
    "\1\275\4\0\1\7\1\134\2\7\1\16\2\7\1\276\1\7\1\62\1\7\1\62\4\0\17\7\1\11\10"+
    "\0\6\7\1\21\20\0\1\277\20\0\3\7\1\21\6\7\1\116\1\0\1\233\3\0\4\7\2\0\3\7\1"+
    "\11\4\7\1\52\1\37\3\7\1\62\4\7\1\215\1\7\1\246\5\0\23\7\1\62\1\4\1\5\4\7\1"+
    "\215\4\7\1\215\5\7\1\0\6\7\1\215\23\0\46\7\1\16\1\0\2\7\1\62\1\0\1\7\23\0"+
    "\1\62\1\74\4\7\1\30\1\300\2\7\1\62\1\0\2\7\1\16\1\0\3\7\1\16\10\0\2\7\1\301"+
    "\1\0\2\7\1\62\1\0\3\7\1\20\10\0\7\7\1\274\10\0\1\302\1\63\1\134\1\6\2\7\1"+
    "\215\1\106\4\0\3\7\1\21\3\7\1\21\4\0\1\7\1\6\2\7\1\303\3\0\6\7\1\62\1\0\2"+
    "\7\1\62\1\0\2\7\1\11\1\0\2\7\1\20\15\0\11\7\1\116\6\0\6\7\1\11\1\0\6\7\1\11"+
    "\41\0\1\220\6\7\1\4\1\152\3\0\1\112\1\4\1\0\1\100\1\220\5\7\1\4\1\37\2\0\3"+
    "\7\1\116\1\4\1\5\1\220\3\7\1\151\1\4\1\132\1\4\2\0\4\7\1\304\1\0\1\220\5\7"+
    "\1\40\1\4\1\305\1\306\1\4\1\307\4\0\2\7\1\27\2\7\1\207\1\4\1\170\10\0\1\16"+
    "\1\310\1\7\1\30\1\7\1\116\5\7\1\151\1\4\1\37\1\4\1\5\1\130\1\72\1\73\2\7\1"+
    "\74\1\114\1\76\1\44\1\107\1\127\1\241\1\70\2\167\21\0\6\7\1\166\1\4\1\171"+
    "\1\11\1\4\1\5\4\0\6\7\2\4\1\311\1\0\1\4\1\5\24\0\5\7\1\151\1\162\1\4\1\233"+
    "\2\0\1\256\4\0\6\7\2\4\1\312\1\0\1\4\1\5\4\0\5\7\1\40\1\4\1\0\1\4\1\5\6\0"+
    "\3\7\1\313\1\4\1\214\1\4\1\5\54\0\10\7\1\4\1\5\1\0\1\142\70\0\7\7\1\116\40"+
    "\0\1\7\1\74\3\7\1\151\1\152\1\4\1\116\1\0\1\4\1\5\2\0\1\32\3\7\1\314\2\4\1"+
    "\34\1\152\51\0\63\7\1\20\14\0\15\7\1\16\2\0\30\7\1\215\27\0\5\7\1\16\72\0"+
    "\10\7\1\16\67\0\7\7\1\116\3\7\1\16\1\4\1\5\14\0\3\7\1\62\1\167\1\0\6\7\1\152"+
    "\1\0\1\215\1\0\1\4\1\5\1\265\2\7\1\241\2\7\56\0\10\7\1\21\1\0\1\67\4\4\1\152"+
    "\1\0\1\100\1\220\1\7\10\0\1\116\3\0\75\7\1\21\2\0\36\7\1\11\41\0\1\20\77\0"+
    "\15\7\1\11\1\7\1\21\1\7\1\116\1\7\1\315\130\0\1\271\1\316\1\37\1\217\1\317"+
    "\1\214\3\0\1\320\22\0\1\306\67\0\12\7\1\23\10\7\1\23\1\321\1\322\1\7\1\323"+
    "\1\134\7\7\1\30\1\324\2\23\3\7\1\325\1\161\1\32\1\74\51\7\1\62\3\7\1\74\2"+
    "\7\1\201\3\7\1\201\2\7\1\23\3\7\1\23\2\7\1\16\3\7\1\16\3\7\1\74\3\7\1\74\2"+
    "\7\1\201\1\326\14\4\1\152\1\217\5\4\1\167\1\277\1\0\1\234\2\0\1\217\1\34\1"+
    "\4\52\0\1\152\2\4\1\327\1\330\1\37\72\0\30\7\1\21\1\0\1\152\5\0\10\7\1\207"+
    "\1\37\1\4\1\5\24\0\1\134\3\7\1\153\1\6\1\201\1\331\1\237\1\332\1\153\1\225"+
    "\1\153\2\201\1\111\1\7\1\27\1\7\1\215\1\333\1\27\1\7\1\215\50\0\32\7\1\16"+
    "\5\0\106\7\1\21\1\0\33\7\1\62\120\7\1\20\53\0\3\7\1\62\134\0\36\4\2\0");

  /* The ZZ_CMAP_A table has 1760 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\2\1\0\1\1\2\0\1\1\2\2\1\0\2\2\1\7\6\2\1\3\5\2\12\4\7\2\22\5\1\2\1\6\2"+
    "\2\4\5\12\2\1\0\2\2\1\0\11\2\1\5\12\2\1\5\1\2\1\4\7\5\1\2\2\5\4\2\4\5\6\2"+
    "\5\5\7\2\1\5\1\2\1\5\1\2\5\5\1\2\2\5\3\2\3\5\1\2\1\5\6\2\1\5\1\4\3\5\1\2\1"+
    "\5\1\2\4\5\1\2\13\5\1\2\3\5\1\2\5\4\2\2\6\5\1\2\1\5\7\2\15\4\1\2\1\4\1\2\2"+
    "\4\1\2\2\4\1\2\4\4\5\2\3\5\7\4\4\2\2\5\1\4\13\5\1\2\1\5\7\4\2\2\6\4\2\5\2"+
    "\4\1\2\4\4\2\5\2\4\3\5\2\2\2\5\1\4\6\5\3\4\2\2\11\5\3\4\1\5\6\2\2\4\6\5\4"+
    "\4\2\5\2\2\2\4\1\5\11\4\1\5\3\4\1\5\5\4\2\2\1\5\3\4\4\2\6\5\6\2\6\4\1\2\11"+
    "\4\6\5\3\4\1\5\2\4\1\5\7\4\2\5\2\4\2\2\2\4\1\5\3\4\1\2\10\5\2\2\2\5\2\2\6"+
    "\5\1\2\7\5\1\2\1\5\3\2\4\5\2\2\1\4\1\5\3\4\2\2\3\4\1\5\10\2\1\4\4\2\2\5\1"+
    "\2\1\5\1\2\3\4\1\2\6\5\4\2\2\5\1\2\2\5\1\2\2\5\1\2\2\5\2\2\1\4\1\2\5\4\4\2"+
    "\2\4\2\2\3\4\3\2\1\4\7\2\4\5\1\2\1\5\7\2\4\4\3\5\1\4\2\2\1\5\1\2\2\5\1\2\3"+
    "\5\2\4\1\2\3\4\2\2\1\5\11\2\1\4\1\5\1\2\6\5\3\2\3\5\1\2\4\5\3\2\2\5\1\2\1"+
    "\5\1\2\2\5\3\2\2\5\3\2\2\5\4\2\5\4\3\2\3\4\1\2\4\4\2\2\1\5\6\2\5\4\1\2\5\5"+
    "\3\2\1\5\7\4\1\2\2\4\5\2\2\4\1\2\4\5\1\2\3\5\6\2\1\5\2\2\2\5\5\2\3\5\2\2\1"+
    "\5\3\4\1\2\4\4\1\5\5\2\3\5\1\4\7\2\1\5\2\2\2\4\1\2\7\5\1\2\1\5\4\2\1\4\4\2"+
    "\6\4\1\2\1\4\3\2\2\4\4\2\1\5\1\4\1\5\5\4\7\5\10\4\2\2\2\5\1\2\1\5\2\2\2\5"+
    "\1\2\1\5\2\2\1\5\6\2\4\5\1\2\3\5\1\2\1\5\1\2\1\5\2\2\2\5\1\2\3\5\2\4\1\2\2"+
    "\4\1\5\2\2\5\5\1\2\1\5\1\2\6\4\2\2\2\4\2\2\4\5\5\2\1\4\1\2\1\4\1\2\1\4\4\2"+
    "\2\4\5\5\10\4\11\2\1\4\1\2\7\4\1\5\2\4\4\5\3\4\1\5\3\4\2\5\7\4\3\5\4\4\5\5"+
    "\14\4\1\5\1\4\5\2\1\5\2\2\3\5\1\2\7\5\2\2\3\4\1\0\11\5\3\4\3\2\2\5\2\4\4\2"+
    "\1\5\1\2\2\4\4\2\4\5\10\4\3\2\1\5\4\2\1\5\1\4\5\2\3\4\2\2\1\5\1\4\1\5\5\2"+
    "\4\4\4\2\4\5\4\2\5\4\3\5\3\2\10\4\5\5\2\4\3\2\3\5\3\4\1\2\5\4\4\5\1\4\4\5"+
    "\3\4\2\5\2\2\1\5\1\2\1\5\1\2\1\5\1\2\1\5\2\2\3\5\1\2\6\5\2\2\2\5\13\0\5\2"+
    "\2\0\5\2\1\0\1\4\13\2\1\4\12\2\1\0\1\2\1\4\3\2\3\4\2\2\1\5\4\2\3\5\2\2\4\5"+
    "\5\2\5\5\4\2\1\5\4\2\4\5\3\4\2\5\4\2\1\0\4\2\3\5\1\2\5\5\3\2\2\4\2\2\3\5\6"+
    "\4\1\2\3\5\1\4\3\5\1\4\4\5\1\4\4\5\3\2\1\5\1\2\1\5\2\2\5\5\1\4\2\5\2\4\5\5"+
    "\1\2\4\5\2\4\4\2\1\5\3\4\2\5\1\4\5\5\2\4\3\2\3\5\4\2\3\5\2\4\2\2\6\5\1\2\3"+
    "\4\1\2\2\4\5\2\5\5\5\2\1\5\1\4\3\5\1\2\2\5\1\2\2\5\3\2\2\4\10\2\3\4\1\2\1"+
    "\5\1\2\1\5\3\2\4\5\4\2\1\4\6\2\2\5\2\2\3\5\3\2\3\5\1\2\2\5\1\2\1\5\5\2\1\4"+
    "\2\2\1\5\3\2\1\5\2\2\4\5\1\2\2\5\2\2\1\5\3\4\1\2\2\4\1\2\5\5\2\4\1\2\3\5\1"+
    "\4\2\2\1\5\1\2\1\4\4\5\5\2\3\4\3\2\2\4\1\5\1\2\1\5\3\2\1\5\1\2\4\5\1\2\1\5"+
    "\4\4\2\5\1\2\1\5\1\4\3\2\1\5\3\2\2\5\3\2\3\4\2\2\6\4\2\5\3\2\2\4\1\2\2\4\3"+
    "\2\6\4\2\2\3\4\2\2\4\4\4\2\1\5\2\2\2\5\2\2\4\5\1\2\4\5\1\2\1\5\1\2\6\5\2\2"+
    "\5\5\1\2\4\5\1\2\4\5\2\2\3\4\2\2\7\4\1\2\2\4\1\2\2\4\1\2\1\5\1\2\1\5\5\2\1"+
    "\5\1\2\1\5\1\2\3\5\1\2\3\5\1\2\3\5");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7";

  private static int [] zzUnpackAction() {
    int [] result = new int[9];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\10\0\20\0\30\0\30\0\40\0\50\0\30"+
    "\0\60";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[9];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\5\1\7\1\10\1\11"+
    "\10\5\1\3\22\0\1\6\10\0\2\7\11\0\1\11";

  private static int [] zzUnpackTrans() {
    int [] result = new int[56];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\1\2\11\2\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[9];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  public int zzState;

  /** the current lexical state */
  public int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  public CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  public int zzMarkedPos;

  /** the current text position in the buffer */
  public int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  public int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  public int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  public boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  public boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  public boolean zzEOFDone;

  /* user code: */
private final ParsingStack stack = new ParsingStack();
public _NotedownLexer() {
	this((java.io.Reader)null);
}



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _NotedownLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return stack.analyzeWhitespace(this);
            } 
            // fall through
          case 8: break;
          case 2: 
            { return stack.analyzeNewline(this);
            } 
            // fall through
          case 9: break;
          case 3: 
            { return PLAIN_TEXT;
            } 
            // fall through
          case 10: break;
          case 4: 
            { return stack.analyzeStar(this);
            } 
            // fall through
          case 11: break;
          case 5: 
            { return stack.analyzeSymbol(this);
            } 
            // fall through
          case 12: break;
          case 6: 
            { return stack.analyzeEscape(this);
            } 
            // fall through
          case 13: break;
          case 7: 
            { return stack.analyzeHeadHash(this);
            } 
            // fall through
          case 14: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
