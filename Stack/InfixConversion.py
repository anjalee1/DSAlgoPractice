
from collections import deque

def infix(exp):
    prefix=deque()
    postfix=deque()
    operators=deque()
    for ch in exp:
        if ch=='(':
            operators.append(ch)
        elif ch==')':
            while len(operators)>0 and operators[-1]!='(':
              process(operators,prefix,postfix)  
            operators.pop() 
        elif ch=='+' or  ch=='-' or ch=='*' or ch=='/':
            while len(operators)>0 and operators[-1]!='(' and precedence(ch)<=precedence(operators[-1]):
              process(operators,prefix,postfix)  
            operators.append(ch)
        else:
          postfix.append(ch)
          prefix.append(ch)
    

    while len(operators)>0:
        process(operators,prefix,postfix) 


    print(postfix[-1],end="\n")
    print(prefix[-1],end="\n")



def precedence(character):
    if character=='-' or character== '+':
        return 1
    elif character== '*' or character=='/':
       return 2

def process(operators,prefix,postfix):
    op=operators.pop() 

    preval2=prefix.pop() 
    preval1=prefix.pop() 
    prefix.append(op+preval1+preval2)
    
    postval2=postfix.pop()
    postval1=postfix.pop()
    postfix.append(postval1+postval2+op)

exp = list(input()) 
infix(exp)
