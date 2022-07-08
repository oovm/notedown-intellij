// This is a generated file. Not intended for manual editing.
package notedge.idea.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import notedge.idea.language.psi_node.*;

public interface NoteTypes {

  IElementType BRACE_BLOCK = new NoteElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new NoteElementType("BRACKET_BLOCK");
  IElementType IDENTIFIER = new NoteElementType("IDENTIFIER");
  IElementType ITALIC = new NoteElementType("ITALIC");
  IElementType TEXT_FUNCTION = new NoteElementType("TEXT_FUNCTION");

  IElementType ACCENT = new NoteTokenType("^");
  IElementType ANGLE_L = new NoteTokenType("<");
  IElementType ANGLE_R = new NoteTokenType(">");
  IElementType AT = new NoteTokenType("@");
  IElementType BRACE_L = new NoteTokenType("{");
  IElementType BRACE_R = new NoteTokenType("}");
  IElementType BRACKET_L = new NoteTokenType("[");
  IElementType BRACKET_R = new NoteTokenType("]");
  IElementType COLON = new NoteTokenType(":");
  IElementType COMMA = new NoteTokenType(",");
  IElementType DOLLAR = new NoteTokenType("$");
  IElementType DOT = new NoteTokenType(".");
  IElementType EQ = new NoteTokenType("=");
  IElementType ESCAPE = new NoteTokenType("\\");
  IElementType ITALIC_L = new NoteTokenType("ITALIC_L");
  IElementType ITALIC_R = new NoteTokenType("**");
  IElementType PARENTHESIS_L = new NoteTokenType("(");
  IElementType PARENTHESIS_R = new NoteTokenType(")");
  IElementType SEMICOLON = new NoteTokenType(";");
  IElementType STAR = new NoteTokenType("*");
  IElementType SYMBOL = new NoteTokenType("SYMBOL");
  IElementType TEXT = new NoteTokenType("TEXT");

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
