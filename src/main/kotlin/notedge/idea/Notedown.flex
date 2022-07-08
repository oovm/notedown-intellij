package notedge.idea;

import com.intellij.lexer.FlexLexer;
import notedge.idea.language.ast.ParsingStack;

import com.intellij.psi.tree.IElementType;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static notedge.idea.language.psi.NoteTypes.*;

%%

%{
private final ParsingStack stack = new ParsingStack();
public _NotedownLexer() {
	this((java.io.Reader)null);
}

%}

%public
%class _NotedownLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+
NEW_LINE=[\r\n]\s*
COMMENT_DOCUMENT=("///")[^\r\n]*
COMMENT=("//")[^\r\n]*
COMMENT_BLOCK=[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
URL= [A-Za-z0-9]+:"//"[\-\p{XID_Continue}./?&#]+
SYMBOL=[\p{XID_Start}_][\p{XID_Continue}_]*
STRING=\"([^\"\\]|\\.)*\"
BYTE=(0[bBoOxXfF][0-9A-Fa-f][0-9A-Fa-f_]*)
INTEGER=(0|[1-9][0-9_]*)
DECIMAL=([0-9]+\.[0-9]*([*][*][0-9]+)?)|(\.[0-9]+([Ee][0-9]+)?)
SIGN=[+-]
STAR=[*]+
ESCAPE_SPECIAL = \\[*-]
HEADER_HASH=[#]+
%%

<YYINITIAL> {
	{ESCAPE_SPECIAL} {return ESCAPE; }
	{HEADER_HASH} {return stack.analyzeHead(this);}
	{STAR} {return stack.analyzeStar(this);}
//	{NEW_LINE} {return stack.analyzeNewline(yylength());}
}

<YYINITIAL> {
	{WHITE_SPACE}      { return WHITE_SPACE; }
	"\\"               { return ESCAPE; }
	"("                { return PARENTHESIS_L; }
	")"                { return PARENTHESIS_R; }
	"["                { return BRACKET_L; }
	"]"                { return BRACKET_R; }
	"{"                { return BRACE_L; }
	"}"                { return BRACE_R; }
	"<"                { return ANGLE_L; }
	">"                { return ANGLE_R; }
	"^"                { return ACCENT; }
	"="                { return EQ; }
	":"                { return COLON; }
	";"                { return SEMICOLON; }
	","                { return COMMA; }
	"$"                { return DOLLAR; }
	"."                { return DOT; }
	"*"                { return STAR; }
	"@"                { return AT; }
}

//<YYINITIAL> {
//	{SYMBOL}  { return SYMBOL; }
//}

[^] { return TEXT; }
