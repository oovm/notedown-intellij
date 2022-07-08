package notedge.idea;

import notedge.idea.language.psi.ParsingStack;

import com.intellij.psi.tree.IElementType;
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

%state CodeFragment

EOL=\R
WHITE_SPACE=[^\S\r\n]+
NEW_LINE=[\r\n]
URL= [A-Za-z0-9]+:"//"[\-\p{XID_Continue}./?&#]+
SYMBOL=[\p{XID_Start}_][\p{XID_Continue}_]*
STRING=\"([^\"\\]|\\.)*\"
BYTE=(0[bBoOxXfF][0-9A-Fa-f][0-9A-Fa-f_]*)
INTEGER=(0|[1-9][0-9_]*)
DECIMAL=([0-9]+\.[0-9]*([*][*][0-9]+)?)|(\.[0-9]+([Ee][0-9]+)?)
SIGN=[+-]
ASTERISK=[*]+
TILDE=[~]+
ESCAPE = \\
HEADER_HASH=[#]+
%%

<YYINITIAL> {
	{WHITE_SPACE} {return stack.analyzeWhitespace(this);}
	{NEW_LINE} {return stack.analyzeNewline(this);}

	{HEADER_HASH} {return stack.analyzeHeadHash(this);}

	{ESCAPE} {return stack.analyzeEscape(this);}
	{ASTERISK} {return stack.analyzeAsterisk(this);}
	{ASTERISK} {return stack.analyzeTilde(this);}
	{SYMBOL} {return stack.analyzeSymbol(this);}
//	{NEW_LINE} {return stack.analyzeNewline(yylength());}
}

[^] { return PLAIN_TEXT; }
