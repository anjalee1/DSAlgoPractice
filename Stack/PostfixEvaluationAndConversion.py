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
    prefix=deque()
    for ch in exp:
       if ch=='+' or ch=='-' or ch=='*' or ch=='/':
           val2=values.pop()
           val1=values.pop()
           value=operation(ch,val1,val2)
           values.append(int(value))

           inval2=infix.pop()
           inval1=infix.pop()
           invalue='('+inval1+ch+inval2+')'
           infix.append(invalue)

           preval2=prefix.pop()
           preval1=prefix.pop()
           prevalue=ch+preval1+preval2
           prefix.append(prevalue)


       else:
           values.append(int(ch))
           infix.append(ch)
           prefix.append(ch)
    print(values.pop())
    print(infix.pop())
    print(prefix.pop())
           





exp = list(input())

prefix(exp)
