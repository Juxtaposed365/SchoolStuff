'''
Symbols: 

Addition  +
Assignment  =
Subtraction  -
Division  /
Multiplication  *
Modulo Operator  %
Logical And  &&&
Logical Or  |||
Logical Not !
Open Code Block  {
Close Code Block  }
Open Function parameter  (
Close Function parameter  )
Open Array index parameter  [ 
Close Array index parameter  ]

Types:

String  string
Integer  int
Character  char
Float  float
Void  void

Identifiers:

$ Scalar Variables
@ Arrays
% Hash Maps

Literals: 

Java-Style string literals  "......"
C-Style integer literals  2309223423
C-Style character literals  'c'
C-Style floating point literals  2234324.432423
'''

import re

# Here are all the regex patterns for each token
# for all ids [\$|\@|\%][a-zA-Z0-9_]+
token_pattern = r"""
(?P<Private_Scalar_Identifier>[\$][_][a-zA-Z0-9]+[a-zA-Z0-9_]+)
|(?P<Private_Array_Identifier>[\@][_][a-zA-Z0-9]+[a-zA-Z0-9_]+)
|(?P<Private_Hash_Identifier>[\%][_][a-zA-Z0-9]+[a-zA-Z0-9_]+)
|(?P<Standard_Scalar_Identifier>[\$][a-zA-Z0-9_]+)
|(?P<Standard_Array_Identifier>[\@][a-zA-Z0-9_]+)
|(?P<Standard_Hash_Identifier>[\%][a-zA-Z0-9_]+)
|(?P<Integer_Literal>[0-9]+)
|(?P<Float_Literal>[0-9]+\.[0-9]+|\.[0-9]+)
|(?P<String_Literal>\".+\")
|(?P<Char_Literal>\'.\')
|(?P<Addition>[\+])
|(?P<Subtraction>-)
|(?P<Multiplication>\*)
|(?P<Division>/)
|(?P<Modulus>%)
|(?P<Not>!)
|(?P<And>&&&)
|(?P<Or>\|\|\|)
|(?P<Left_Curly>{)
|(?P<Right_Curly>})
|(?P<Left_Square>\[)
|(?P<Right_Square>\])
|(?P<Left_Paren>\()
|(?P<Right_Paren>\))
|(?P<Newline>\n)
|(?P<Space>\s+)
|(?P<Assignment>=)
|(?P<String_Type>string)
|(?P<Integer_Type>int)
|(?P<Character_Type>char)
|(?P<Float_Type>float)
|(?P<Void_Type>void)
"""
tokenPatterns = re.compile(token_pattern, re.VERBOSE)
# This function goes through a str and creates a tuple that includes the
# type of token and it's value
def getTokens(code):
    pos = 0
    while True:
        a_match = tokenPatterns.match(code, pos)
        if not a_match: break
        pos = a_match.end()
        token_type = a_match.lastgroup
        token_value = a_match.group(token_type)
        yield token_type, token_value
    if pos != len(code):
        print("Can't find token")

# reading from the test file
test = open("test.txt", "r")
str = test.read() 
all_tokens = []
for token in getTokens(str):
    all_tokens.append(token)
# printing them all out
for item in all_tokens:
    if(item[0] == 'Space' or item[0] == 'Newline'):
        continue
    else:
        print(item[0],'-->',item[1])


