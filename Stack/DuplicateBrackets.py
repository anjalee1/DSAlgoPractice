from sys import stdin
from collections import deque


def CheckDuplicateBrackets(string):
    myStack = deque()
    for ch in string:
        if ch==')':
            if myStack[-1]=='(':
                print("true")
                return
            else:
                while myStack[-1]!='(':
                    myStack.pop()
                myStack.pop()
                    
        else:
            myStack.append(ch)
    print("false")             


expression = stdin.readline()
CheckDuplicateBrackets(expression)
