
from sys import stdin
from collections import deque
def display(arr) :
	for i in range(len(arr)) :
		print(arr[i], end = "\n")
def solve(pric):
    span=[0]*len(pric)
    stack=deque()
    span[0]=1
    stack.append(0)
    for i in range(1,len(pric)):
        while len(stack)>0 and pric[i]>=pric[stack[-1]]:
            stack.pop()
        if len(stack)==0:
            span[i]=i+1
        else:
            span[i]=i-stack[-1]
        stack.append(i)
    return span
    

    
n = int(input())
price =[]
for i in range (n):
    x = int(input())
    price.append(x)

span=solve(price)
display(span)
