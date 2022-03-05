from collections import deque
def slidingWindow(arr, k1):
    stack=deque()
    nge=[0]*len(arr)
    stack.append(len(arr)-1)
    nge[-1]=len(arr)

    for i in range(len(arr)-2,-1,-1):
        while len(stack)>0 and arr[i]>=arr[stack[-1]]:
            stack.pop()
        if not stack:
           nge[i]=len(arr)
        else:
            nge[i]=stack[-1]
        stack.append(i)
    j=0
    for i in range(len(arr)-k1+1):
        if j<i:
            j=i
        while nge[j]<i+k1:
            j=nge[j]
        print(arr[j])
    

n = int(input())
arr = [] * n
for i in range(n):
    x = int(input())
    arr.append(x)
k = int(input())

slidingWindow(arr, k)
