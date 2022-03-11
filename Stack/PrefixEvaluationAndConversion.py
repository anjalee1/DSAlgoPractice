
from collections import deque
def operation(ch,v1,v2):
    if ch=='+':
        return v1 + v2
    if ch=='-':
        return v1 - v2
    if ch=='*':
        return v1 * v2
    if ch=='/':
        return v1 / v2


def prefix(exp):
    values=deque()
    infix=deque()
    postfix=deque()
    for ch in reversed(exp):
       if ch=='+' or ch=='-' or ch=='*' or ch=='/':
           val1=values.pop()
           val2=values.pop()
           value=operation(ch,val1,val2)
           values.append(int(value))

           inval1=infix.pop()
           inval2=infix.pop()
           invalue='('+inval1+ch+inval2+')'
           infix.append(invalue)

           postval1=postfix.pop()
           postval2=postfix.pop()
           postvalue=postval1+postval2+ch
           postfix.append(postvalue)


       else:
           values.append(int(ch))
           infix.append(ch)
           postfix.append(ch)
    print(values.pop())
    print(infix.pop())
    print(postfix.pop())
           





exp = list(input())

prefix(exp)
