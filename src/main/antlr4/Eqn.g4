grammar Eqn;

eqn:
        IF eqn THEN eqn ELSE eqn                          # IfThenElse
    |   '(' eqn ')'                                       # Parens
    |   VAR '[' eqn (',' eqn)* ']'                        # ArrayAccess
    |   VAR ('(' ')' | '(' eqn (',' eqn)* ')')            # FunCall
    |   <assoc=right> eqn POW eqn                         # Power
    |   <assoc=right> op=('+' | '-') eqn                  # UnarySign
    |   <assoc=right> NOT eqn                             # Not
    |   eqn op=( '*' | '/' | MOD ) eqn                    # MulDiv
    |   eqn op=('+'|'-') eqn                              # AddSub
    |   eqn op=( EQ | NEQ | GT | GE | LT | LE ) eqn       # Comp
    |   eqn op=( AND | OR ) eqn                           # Logic
    |   NUMBER                                            # number
    |   VAR                                               # var
    ;


POW :   '^' | '**' ;
MUL :   '*' ;
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
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
ID  :   [a-zA-Z_]+ ;
STR :   '"' .+? '"';
NUMBER:  [0-9]+ ('.' [0-9]+)? NUM_EXP? | '.' [0-9]+ NUM_EXP? ;
NUM_EXP: ('e' | 'E') [+-]? [0-9]+ ;

WS  :   [ \t\r\n]+ -> skip ; // skip all whitespaces
