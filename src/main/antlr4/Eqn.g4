grammar Eqn;

eqn:
        IF eqn THEN eqn ELSE eqn                # IfThenElse
    |   VAR ('(' ')' | '(' eqn (',' eqn)* ')')  # FunCall
    |   VAR '[' eqn (',' eqn)* ']'              # ArrayAccess
    |   eqn '^' eqn                             # Power
    |   eqn ('*'|'/') eqn                       # MulDiv
    |   eqn ('+'|'-') eqn                       # AddSub
    |   eqn ('<'|'>'|'='|'=='|'!='|'<>'|'<='|'>=') eqn    # Comp
    |   NUMBER                                  # number
    |   '(' eqn ')'                             # parens
    |   VAR                                     # var
    ;


MUL :   '*' ; // defines a token for '*'
DIV :   '/' ; // defines a token for '/'
ADD :   '+' ; // defines a token for '+'
SUB :   '-' ; // defines a token for '-'
POW :   '^' ;
MOD :   [mM][oO][dD] | '%' ;
NOT :   [nN][oO][tT] | '!' ;
AND :   [aA][nN][dD] | '&' ;
OR  :   [oO][rR] | '|' ;
EQ  :   '=' | '==' ;
NEQ :   '!=' | '<>' ;
GT  :   '>' ;
GE  :   '>=' ;
LT  :   '<' ;
LE  :   '<=' ;
IF  :   [iI][fF] ;
THEN:   [tT][hH][eE][nN] ;
ELSE:   [eE][lL][sS][eE] ;

VAR :   STR | ID;
ID  :   [a-zA-Z_]+ ;      // match identifiers
STR :   '"' .+? '"';
NUMBER:  [0-9]+ ('.' [0-9]+)? NUM_EXP? | '.' [0-9]+ NUM_EXP? ;
NUM_EXP: ('e' | 'E') [+-]? [0-9]+ ;

WS  :   [ \t\r\n]+ -> skip ; // skip all whitespaces
