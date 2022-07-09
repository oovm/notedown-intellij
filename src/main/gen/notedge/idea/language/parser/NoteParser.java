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
  // <<parenthesis argument COMMA>>
  public static boolean args_function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_function")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, NoteParser::argument, COMMA_parser_);
    exit_section_(b, m, ARGS_FUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // COLON STRING_TEXT?
  public static boolean args_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_text")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && args_text_1(b, l + 1);
    exit_section_(b, m, ARGS_TEXT, r);
    return r;
  }

  // STRING_TEXT?
  private static boolean args_text_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_text_1")) return false;
    consumeToken(b, STRING_TEXT);
    return true;
  }

  /* ********************************************************** */
  // [key (EQ|COLON)] value
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument_0(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, ARGUMENT, r);
    return r;
  }

  // [key (EQ|COLON)]
  private static boolean argument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_0")) return false;
    argument_0_0(b, l + 1);
    return true;
  }

  // key (EQ|COLON)
  private static boolean argument_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && argument_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQ|COLON
  private static boolean argument_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_0_0_1")) return false;
    boolean r;
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, COLON);
    return r;
  }

  /* ********************************************************** */
  // BOLD_L   [text_elements] BOLD_R
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
  // CODE_S string CODE_E
  public static boolean code_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_block")) return false;
    if (!nextTokenIs(b, CODE_S)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CODE_S);
    r = r && string(b, l + 1);
    r = r && consumeToken(b, CODE_E);
    exit_section_(b, m, CODE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // CODE_L string? CODE_R
  public static boolean code_inline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_inline")) return false;
    if (!nextTokenIs(b, CODE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CODE_L);
    r = r && code_inline_1(b, l + 1);
    r = r && consumeToken(b, CODE_R);
    exit_section_(b, m, CODE_INLINE, r);
    return r;
  }

  // string?
  private static boolean code_inline_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "code_inline_1")) return false;
    string(b, l + 1);
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
  // ESCAPE namespace [args_function] [args_text] {
  // }
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, ESCAPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ESCAPE);
    r = r && namespace(b, l + 1);
    r = r && function_2(b, l + 1);
    r = r && function_3(b, l + 1);
    r = r && function_4(b, l + 1);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  // [args_function]
  private static boolean function_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_2")) return false;
    args_function(b, l + 1);
    return true;
  }

  // [args_text]
  private static boolean function_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_3")) return false;
    args_text(b, l + 1);
    return true;
  }

  // {
  // }
  private static boolean function_4(PsiBuilder b, int l) {
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
  // identifier
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, KEY, r);
    return r;
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
  // PARENTHESIS_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && parenthesis_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean parenthesis_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1")) return false;
    parenthesis_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean parenthesis_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && parenthesis_1_0_1(b, l + 1, _sp, _item);
    r = r && parenthesis_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean parenthesis_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parenthesis_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "parenthesis_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean parenthesis_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean parenthesis_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // header
  //   | function
  //   | xml
  //   | text_elements
  //   | code_block
  //   | BREAK_PART
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = header(b, l + 1);
    if (!r) r = function(b, l + 1);
    if (!r) r = xml(b, l + 1);
    if (!r) r = text_elements(b, l + 1);
    if (!r) r = code_block(b, l + 1);
    if (!r) r = consumeToken(b, BREAK_PART);
    return r;
  }

  /* ********************************************************** */
  // STRIKE_L [text_elements] STRIKE_R
  public static boolean strike(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "strike")) return false;
    if (!nextTokenIs(b, STRIKE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRIKE_L);
    r = r && strike_1(b, l + 1);
    r = r && consumeToken(b, STRIKE_R);
    exit_section_(b, m, STRIKE, r);
    return r;
  }

  // [text_elements]
  private static boolean strike_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "strike_1")) return false;
    text_elements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (STRING_TEXT | ESCAPE_TEXT)+
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    if (!nextTokenIs(b, "<string>", ESCAPE_TEXT, STRING_TEXT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = string_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!string_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING_TEXT | ESCAPE_TEXT
  private static boolean string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_0")) return false;
    boolean r;
    r = consumeToken(b, STRING_TEXT);
    if (!r) r = consumeToken(b, ESCAPE_TEXT);
    return r;
  }

  /* ********************************************************** */
  // STRONG_L [text_elements] STRONG_R
  public static boolean strong(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "strong")) return false;
    if (!nextTokenIs(b, STRONG_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRONG_L);
    r = r && strong_1(b, l + 1);
    r = r && consumeToken(b, STRONG_R);
    exit_section_(b, m, STRONG, r);
    return r;
  }

  // [text_elements]
  private static boolean strong_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "strong_1")) return false;
    text_elements(b, l + 1);
    return true;
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
  // PLAIN_TEXT | escaped | ESCAPE | NEW_LINE | italic | bold | strong | under | strike | wave | code_inline
  static boolean text_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_item")) return false;
    boolean r;
    r = consumeToken(b, PLAIN_TEXT);
    if (!r) r = escaped(b, l + 1);
    if (!r) r = consumeToken(b, ESCAPE);
    if (!r) r = consumeToken(b, NEW_LINE);
    if (!r) r = italic(b, l + 1);
    if (!r) r = bold(b, l + 1);
    if (!r) r = strong(b, l + 1);
    if (!r) r = under(b, l + 1);
    if (!r) r = strike(b, l + 1);
    if (!r) r = wave(b, l + 1);
    if (!r) r = code_inline(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // UNDER_L  [text_elements] UNDER_R
  public static boolean under(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "under")) return false;
    if (!nextTokenIs(b, UNDER_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNDER_L);
    r = r && under_1(b, l + 1);
    r = r && consumeToken(b, UNDER_R);
    exit_section_(b, m, UNDER, r);
    return r;
  }

  // [text_elements]
  private static boolean under_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "under_1")) return false;
    text_elements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // namespace
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namespace(b, l + 1);
    exit_section_(b, m, VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // WAVE_L   [text_elements] WAVE_R
  public static boolean wave(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wave")) return false;
    if (!nextTokenIs(b, WAVE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WAVE_L);
    r = r && wave_1(b, l + 1);
    r = r && consumeToken(b, WAVE_R);
    exit_section_(b, m, WAVE, r);
    return r;
  }

  // [text_elements]
  private static boolean wave_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wave_1")) return false;
    text_elements(b, l + 1);
    return true;
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
  // ANGLE_L  namespace ANGLE_SR
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
  // ANGLE_L  namespace ANGLE_R
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

  static final Parser COMMA_parser_ = (b, l) -> consumeToken(b, COMMA);
}
