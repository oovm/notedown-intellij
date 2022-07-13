// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import notedge.idea.language.psi_node.*;

public interface NoteTypes {

  IElementType ARGS_BLOCK = new NElementType("ARGS_BLOCK");
  IElementType ARGS_FUNCTION = new NElementType("ARGS_FUNCTION");
  IElementType ARGS_TEXT = new NElementType("ARGS_TEXT");
  IElementType ARGUMENT = new NElementType("ARGUMENT");
  IElementType BOLD = new NElementType("BOLD");
  IElementType BRACE_BLOCK = new NElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new NElementType("BRACKET_BLOCK");
  IElementType CODE_BLOCK = new NElementType("CODE_BLOCK");
  IElementType ESCAPED = new NElementType("ESCAPED");
  IElementType FUNCTION = new NElementType("FUNCTION");
  IElementType HEADER = new NElementType("HEADER");
  IElementType IDENTIFIER = new NElementType("IDENTIFIER");
  IElementType ITALIC = new NElementType("ITALIC");
  IElementType KEY = new NElementType("KEY");
  IElementType LIST = new NElementType("LIST");
  IElementType MATH = new NElementType("MATH");
  IElementType NAMESPACE = new NElementType("NAMESPACE");
  IElementType SNIPPET = new NElementType("SNIPPET");
  IElementType STRIKE = new NElementType("STRIKE");
  IElementType STRING = new NElementType("STRING");
  IElementType STRONG = new NElementType("STRONG");
  IElementType TEXT_ELEMENTS = new NElementType("TEXT_ELEMENTS");
  IElementType UNDER = new NElementType("UNDER");
  IElementType VALUE = new NElementType("VALUE");
  IElementType WAVE = new NElementType("WAVE");
  IElementType XML_CLOSED = new NElementType("XML_CLOSED");
  IElementType XML_END = new NElementType("XML_END");
  IElementType XML_FUNCTION = new NElementType("XML_FUNCTION");
  IElementType XML_START = new NElementType("XML_START");

  IElementType ACCENT = new NElementType("^");
  IElementType ANGLE_L = new NElementType("ANGLE_L");
  IElementType ANGLE_R = new NElementType("ANGLE_R");
  IElementType ANGLE_SL = new NElementType("ANGLE_SL");
  IElementType ANGLE_SR = new NElementType("ANGLE_SR");
  IElementType AT = new NElementType("@");
  IElementType BOLD_L = new NElementType("BOLD_L");
  IElementType BOLD_R = new NElementType("BOLD_R");
  IElementType BRACE_L = new NElementType("BRACE_L");
  IElementType BRACE_R = new NElementType("BRACE_R");
  IElementType BRACKET_L = new NElementType("BRACKET_L");
  IElementType BRACKET_R = new NElementType("BRACKET_R");
  IElementType BREAK_PART = new NElementType("BREAK_PART");
  IElementType CODE_E = new NElementType("CODE_E");
  IElementType CODE_L = new NElementType("CODE_L");
  IElementType CODE_R = new NElementType("CODE_R");
  IElementType CODE_S = new NElementType("CODE_S");
  IElementType COLON = new NElementType(":");
  IElementType COMMA = new NElementType(",");
  IElementType DOLLAR = new NElementType("$");
  IElementType DOT = new NElementType(".");
  IElementType EQ = new NElementType("=");
  IElementType ESCAPE = new NElementType("\\");
  IElementType ESCAPED_CHARACTER = new NElementType("ESCAPED_CHARACTER");
  IElementType ESCAPE_TEXT = new NElementType("ESCAPE_TEXT");
  IElementType HEADER_HASH = new NElementType("HEADER_HASH");
  IElementType ITALIC_L = new NElementType("ITALIC_L");
  IElementType ITALIC_R = new NElementType("ITALIC_R");
  IElementType MATH_L = new NElementType("MATH_L");
  IElementType MATH_R = new NElementType("MATH_R");
  IElementType NEW_LINE = new NElementType("NewLine");
  IElementType PARENTHESIS_L = new NElementType("PARENTHESIS_L");
  IElementType PARENTHESIS_R = new NElementType("PARENTHESIS_R");
  IElementType PLAIN_TEXT = new NElementType("PLAIN_TEXT");
  IElementType SEMICOLON = new NElementType(";");
  IElementType STAR = new NElementType("*");
  IElementType STRIKE_L = new NElementType("STRIKE_L");
  IElementType STRIKE_R = new NElementType("STRIKE_R");
  IElementType STRING_TEXT = new NElementType("STRING_TEXT");
  IElementType STRONG_L = new NElementType("STRONG_L");
  IElementType STRONG_R = new NElementType("STRONG_R");
  IElementType SYMBOL = new NElementType("SYMBOL");
  IElementType UNDER_L = new NElementType("UNDER_L");
  IElementType UNDER_R = new NElementType("UNDER_R");
  IElementType WAVE_L = new NElementType("WAVE_L");
  IElementType WAVE_R = new NElementType("WAVE_R");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGS_BLOCK) {
        return new NoteArgsBlockNode(node);
      }
      else if (type == ARGS_FUNCTION) {
        return new NoteArgsFunctionNode(node);
      }
      else if (type == ARGS_TEXT) {
        return new NoteArgsTextNode(node);
      }
      else if (type == ARGUMENT) {
        return new NoteArgumentNode(node);
      }
      else if (type == BOLD) {
        return new NoteBoldNode(node);
      }
      else if (type == BRACE_BLOCK) {
        return new NoteBraceBlockNode(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new NoteBracketBlockNode(node);
      }
      else if (type == CODE_BLOCK) {
        return new NoteCodeBlockNode(node);
      }
      else if (type == ESCAPED) {
        return new NoteEscapedNode(node);
      }
      else if (type == FUNCTION) {
        return new NoteFunctionNode(node);
      }
      else if (type == HEADER) {
        return new NoteHeaderNode(node);
      }
      else if (type == IDENTIFIER) {
        return new NoteIdentifierNode(node);
      }
      else if (type == ITALIC) {
        return new NoteItalicNode(node);
      }
      else if (type == KEY) {
        return new NoteKeyNode(node);
      }
      else if (type == LIST) {
        return new NoteListNode(node);
      }
      else if (type == MATH) {
        return new NoteMathNode(node);
      }
      else if (type == NAMESPACE) {
        return new NoteNamespaceNode(node);
      }
      else if (type == SNIPPET) {
        return new NoteSnippetNode(node);
      }
      else if (type == STRIKE) {
        return new NoteStrikeNode(node);
      }
      else if (type == STRING) {
        return new NoteStringNode(node);
      }
      else if (type == STRONG) {
        return new NoteStrongNode(node);
      }
      else if (type == TEXT_ELEMENTS) {
        return new NoteTextElementsNode(node);
      }
      else if (type == UNDER) {
        return new NoteUnderNode(node);
      }
      else if (type == VALUE) {
        return new NoteValueNode(node);
      }
      else if (type == WAVE) {
        return new NoteWaveNode(node);
      }
      else if (type == XML_CLOSED) {
        return new NoteXmlClosedNode(node);
      }
      else if (type == XML_END) {
        return new NoteXmlEndNode(node);
      }
      else if (type == XML_FUNCTION) {
        return new NoteXmlFunctionNode(node);
      }
      else if (type == XML_START) {
        return new NoteXmlStartNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
