// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import notedge.idea.language.psi_node.*;

public interface NoteTypes {

  IElementType BRACE_BLOCK = new NElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new NElementType("BRACKET_BLOCK");
  IElementType IDENTIFIER = new NElementType("IDENTIFIER");
  IElementType ITALIC = new NElementType("ITALIC");
  IElementType TEXT_FUNCTION = new NElementType("TEXT_FUNCTION");

  IElementType ACCENT = new NElementType("^");
  IElementType ANGLE_L = new NElementType("<");
  IElementType ANGLE_R = new NElementType(">");
  IElementType AT = new NElementType("@");
  IElementType BOLD_L = new NElementType("BoldLeft");
  IElementType BOLD_R = new NElementType("BoldRight");
  IElementType BRACE_L = new NElementType("{");
  IElementType BRACE_R = new NElementType("}");
  IElementType BRACKET_L = new NElementType("[");
  IElementType BRACKET_R = new NElementType("]");
  IElementType COLON = new NElementType(":");
  IElementType COMMA = new NElementType(",");
  IElementType DOLLAR = new NElementType("$");
  IElementType DOT = new NElementType(".");
  IElementType EQ = new NElementType("=");
  IElementType ESCAPE = new NElementType("ESCAPE");
  IElementType ESCAPED_CHARACTER = new NElementType("\\");
  IElementType ITALIC_BOLD_L = new NElementType("ItalicBoldLeft");
  IElementType ITALIC_BOLD_R = new NElementType("ItalicBoldRight");
  IElementType ITALIC_L = new NElementType("ItalicLeft");
  IElementType ITALIC_R = new NElementType("ItalicRight");
  IElementType PARENTHESIS_L = new NElementType("(");
  IElementType PARENTHESIS_R = new NElementType(")");
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
      else if (type == IDENTIFIER) {
        return new NoteIdentifierNode(node);
      }
      else if (type == ITALIC) {
        return new NoteItalicNode(node);
      }
      else if (type == TEXT_FUNCTION) {
        return new NoteTextFunctionNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
