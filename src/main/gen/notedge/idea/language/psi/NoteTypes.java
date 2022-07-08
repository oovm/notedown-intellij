// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import notedge.idea.language.psi_node.*;

public interface NoteTypes {

  IElementType BRACE_BLOCK = new NElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new NElementType("BRACKET_BLOCK");
  IElementType ESCAPED = new NElementType("ESCAPED");
  IElementType FUNCTION = new NElementType("FUNCTION");
  IElementType HEADER = new NElementType("HEADER");
  IElementType IDENTIFIER = new NElementType("IDENTIFIER");
  IElementType ITALIC = new NElementType("ITALIC");
  IElementType NAMESPACE = new NElementType("NAMESPACE");
  IElementType XML = new NElementType("XML");
  IElementType XML_CLOSE = new NElementType("XML_CLOSE");
  IElementType XML_END = new NElementType("XML_END");
  IElementType XML_START = new NElementType("XML_START");

  IElementType ACCENT = new NElementType("^");
  IElementType ANGLE_L = new NElementType("ANGLE_L");
  IElementType ANGLE_R = new NElementType("ANGLE_R");
  IElementType ANGLE_SL = new NElementType("ANGLE_SL");
  IElementType ANGLE_SR = new NElementType("ANGLE_SR");
  IElementType AT = new NElementType("@");
  IElementType BRACE_L = new NElementType("BRACE_L");
  IElementType BRACE_R = new NElementType("BRACE_R");
  IElementType BRACKET_L = new NElementType("BRACKET_L");
  IElementType BRACKET_R = new NElementType("BRACKET_R");
  IElementType COLON = new NElementType(":");
  IElementType COMMA = new NElementType(",");
  IElementType DOLLAR = new NElementType("$");
  IElementType DOT = new NElementType(".");
  IElementType EQ = new NElementType("=");
  IElementType ESCAPE = new NElementType("\\\\");
  IElementType ESCAPED_CHARACTER = new NElementType("ESCAPED_CHARACTER");
  IElementType HEADER_HASH = new NElementType("HEADER_HASH");
  IElementType ITALIC_L = new NElementType("ITALIC_L");
  IElementType ITALIC_R = new NElementType("ITALIC_R");
  IElementType PARENTHESIS_L = new NElementType("PARENTHESIS_L");
  IElementType PARENTHESIS_R = new NElementType("PARENTHESIS_R");
  IElementType SEMICOLON = new NElementType(";");
  IElementType STAR = new NElementType("*");
  IElementType SYMBOL = new NElementType("SYMBOL");
  IElementType TEXT = new NElementType("TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BRACE_BLOCK) {
        return new NoteBraceBlockNode(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new NoteBracketBlockNode(node);
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
      else if (type == NAMESPACE) {
        return new NoteNamespaceNode(node);
      }
      else if (type == XML) {
        return new NoteXmlNode(node);
      }
      else if (type == XML_CLOSE) {
        return new NoteXmlCloseNode(node);
      }
      else if (type == XML_END) {
        return new NoteXmlEndNode(node);
      }
      else if (type == XML_START) {
        return new NoteXmlStartNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}