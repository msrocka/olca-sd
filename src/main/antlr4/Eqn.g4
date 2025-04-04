grammar Eqn;

eqn:    eqn ('*'|'/') eqn         # MulDiv
    |   eqn ('+'|'-') eqn         # AddSub
    |   NUMBER                      # number
    |   ID                          # id
    |   '(' eqn ')'                # parens
    ;

MUL :   '*' ; // defines a token for '*'
DIV :   '/' ; // defines a token for '/'
ADD :   '+' ; // defines a token for '+'
SUB :   '-' ; // defines a token for '-'
ID  :   [a-zA-Z_]+ ;      // match identifiers

NUMBER:  [0-9]+ ('.' [0-9]+)? NUM_EXP? | '.' [0-9]+ NUM_EXP? ;
NUM_EXP: ('e' | 'E') [+-]? [0-9]+ ;

WS  :   [ \t\r\n]+ -> skip ; // skip all whitespaces
