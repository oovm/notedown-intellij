// This is a generated file. Not intended for manual editing.
package notedge.idea.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static notedge.idea.language.psi.NoteTypes.*;
import static notedge.idea.language.psi.ParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NoteParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Notedown(b, l + 1);
  }

  /* ********************************************************** */
  // statement*
  static boolean Notedown(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Notedown")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Notedown", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BOLD_L [text_elements] BOLD_R
  public static boolean bold(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bold")) return false;
    if (!nextTokenIs(b, BOLD_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOLD_L);
    r = r && bold_1(b, l + 1);
    r = r && consumeToken(b, BOLD_R);
    exit_section_(b, m, BOLD, r);
    return r;
  }

  // [text_elements]
  private static boolean bold_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bold_1")) return false;
    text_elements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BRACE_L (<<item>>|<<sp>>)* BRACE_R
  public static boolean brace_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, BRACE_BLOCK, r);
    return r;
  }

  // (<<item>>|<<sp>>)*
  private static boolean brace_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_block_1_0(b, l + 1, _item, _sp)) break;
      if (!empty_element_parsed_guard_(b, "brace_block_1", c)) break;
    }
    return true;
  }

  // <<item>>|<<sp>>
  private static boolean brace_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    if (!r) r = _sp.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BRACKET_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACKET_R
  public static boolean bracket_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && bracket_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, BRACKET_BLOCK, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean bracket_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1")) return false;
    bracket_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean bracket_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && bracket_block_1_0_1(b, l + 1, _sp, _item);
    r = r && bracket_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean bracket_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bracket_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "bracket_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean bracket_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean bracket_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // ESCAPED_CHARACTER
  public static boolean escaped(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "escaped")) return false;
    if (!nextTokenIs(b, ESCAPED_CHARACTER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ESCAPED_CHARACTER);
    exit_section_(b, m, ESCAPED, r);
    return r;
  }

  /* ********************************************************** */
  // ESCAPE namespace {
  // }
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, ESCAPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ESCAPE);
    r = r && namespace(b, l + 1);
    r = r && function_2(b, l + 1);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  // {
  // }
  private static boolean function_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // HEADER_HASH text_elements
  public static boolean header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header")) return false;
    if (!nextTokenIs(b, HEADER_HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEADER_HASH);
    r = r && text_elements(b, l + 1);
    exit_section_(b, m, HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // ITALIC_L [text_elements] ITALIC_R
  public static boolean italic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "italic")) return false;
    if (!nextTokenIs(b, ITALIC_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ITALIC_L);
    r = r && italic_1(b, l + 1);
    r = r && consumeToken(b, ITALIC_R);
    exit_section_(b, m, ITALIC, r);
    return r;
  }

  // [text_elements]
  private static boolean italic_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "italic_1")) return false;
    text_elements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ITALIC_BOLD_L [text_elements] ITALIC_BOLD_R
  public static boolean italic_bold(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "italic_bold")) return false;
    if (!nextTokenIs(b, ITALIC_BOLD_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ITALIC_BOLD_L);
    r = r && italic_bold_1(b, l + 1);
    r = r && consumeToken(b, ITALIC_BOLD_R);
    exit_section_(b, m, ITALIC_BOLD, r);
    return r;
  }

  // [text_elements]
  private static boolean italic_bold_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "italic_bold_1")) return false;
    text_elements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier (DOT identifier)*
  public static boolean namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && namespace_1(b, l + 1);
    exit_section_(b, m, NAMESPACE, r);
    return r;
  }

  // (DOT identifier)*
  private static boolean namespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namespace_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespace_1", c)) break;
    }
    return true;
  }

  // DOT identifier
  private static boolean namespace_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L <<param>> PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "parenthesis")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && _param.parse(b, l);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // header
  //   | function
  //   | xml
  //   | text_elements
  //   | BREAK_PART
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = header(b, l + 1);
    if (!r) r = function(b, l + 1);
    if (!r) r = xml(b, l + 1);
    if (!r) r = text_elements(b, l + 1);
    if (!r) r = consumeToken(b, BREAK_PART);
    return r;
  }

  /* ********************************************************** */
  // text_item+
  public static boolean text_elements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_elements")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_ELEMENTS, "<text elements>");
    r = text_item(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!text_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "text_elements", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLAIN_TEXT | escaped | ESCAPE | NEW_LINE | italic | bold | italic_bold
  static boolean text_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_item")) return false;
    boolean r;
    r = consumeToken(b, PLAIN_TEXT);
    if (!r) r = escaped(b, l + 1);
    if (!r) r = consumeToken(b, ESCAPE);
    if (!r) r = consumeToken(b, NEW_LINE);
    if (!r) r = italic(b, l + 1);
    if (!r) r = bold(b, l + 1);
    if (!r) r = italic_bold(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // xml_close | xml_start xml_end
  public static boolean xml(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml")) return false;
    if (!nextTokenIs(b, ANGLE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = xml_close(b, l + 1);
    if (!r) r = xml_1(b, l + 1);
    exit_section_(b, m, XML, r);
    return r;
  }

  // xml_start xml_end
  private static boolean xml_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = xml_start(b, l + 1);
    r = r && xml_end(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ANGLE_L namespace ANGLE_SR
  public static boolean xml_close(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_close")) return false;
    if (!nextTokenIs(b, ANGLE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANGLE_L);
    r = r && namespace(b, l + 1);
    r = r && consumeToken(b, ANGLE_SR);
    exit_section_(b, m, XML_CLOSE, r);
    return r;
  }

  /* ********************************************************** */
  // ANGLE_SL namespace ANGLE_R
  public static boolean xml_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_end")) return false;
    if (!nextTokenIs(b, ANGLE_SL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANGLE_SL);
    r = r && namespace(b, l + 1);
    r = r && consumeToken(b, ANGLE_R);
    exit_section_(b, m, XML_END, r);
    return r;
  }

  /* ********************************************************** */
  // ANGLE_L namespace ANGLE_R
  public static boolean xml_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_start")) return false;
    if (!nextTokenIs(b, ANGLE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANGLE_L);
    r = r && namespace(b, l + 1);
    r = r && consumeToken(b, ANGLE_R);
    exit_section_(b, m, XML_START, r);
    return r;
  }

}
