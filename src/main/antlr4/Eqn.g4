grammar Eqn;

prog:   stat+ ;

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   NEWLINE                     # blank
    ;

expr:   expr ('*'|'/') expr         # MulDiv
    |   expr ('+'|'-') expr         # AddSub
    |   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;

MUL :   '*' ; // defines a token for '*'
DIV :   '/' ; // defines a token for '/'
ADD :   '+' ; // defines a token for '+'
SUB :   '-' ; // defines a token for '-'
ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // match newlines
WS  :   [ \t]+ -> skip ; // skip spaces, tabs
