
from sys import stdin
from collections import deque

def getleftboundary(arr):
  stack=deque()
  lb=[0]*len(arr)
  stack.append(0)
  lb[0]=-1
  for i in range(1,len(arr)):
    while len(stack)>0 and arr[i]<=arr[stack[-1]]:
      stack.pop()
    if not stack :
      lb[i]=-1
    else:
      lb[i]=stack[-1]
    stack.append(i)
  return lb

def getrightboundary(arr):
  stack=deque()
  rb=[0]*len(arr)
  stack.append(len(arr)-1)
  rb[len(arr)-1]=len(arr)
  for i in range(len(arr)-2,-1,-1):
    while len(stack)>0 and arr[i]<=arr[stack[-1]]:
      stack.pop()
    if not stack :
      rb[i]=len(arr)
    else:
      rb[i]=stack[-1]
    stack.append(i)
  return rb

def LargestAreaHistogram(arr):
  lb=getleftboundary(arr)
  rb=getrightboundary(arr)
  maxarea=0
  for i in range(len(arr)):
    area=((rb[i]-lb[i])-1)*arr[i]
    if area>maxarea:
      maxarea=area
  print(maxarea)



n = int(input())
arr =[]
for i in range (n):
    x = int(input())
    arr.append(x)
LargestAreaHistogram(arr)

