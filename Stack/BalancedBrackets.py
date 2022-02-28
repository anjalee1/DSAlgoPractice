from sys import stdin
from collections import deque

def isBalanced(string) :
    s = deque()
    for char in string:
        if char in '{([':
            s.append(char)
        elif char == '}':
            if(not s or s[-1]!='{'):
                return False
            s.pop()
        elif char == ')':
            if(not s or s[-1]!='('):
                return False
            s.pop()
        elif char == ']':
            if(not s or s[-1]!='['):
                return False
            s.pop()
    if(not s):
        return True
    return False





expression = stdin.readline()
if isBalanced(expression) :
	print("true",end="\n")

else :
	print("false",end="\n")
