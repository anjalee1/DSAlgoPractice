
import sys
sys.setrecursionlimit(10**6)
def firstIndex(arr,idx,x):
    if idx==len(arr):
        return -1
    if arr[idx]==x:
        return idx
    else:
        fiisa=firstIndex(arr,idx+1,x)
        return fiisa
n=int(input())
arr=[]
for  i in range(0,n):
    arr.append(int(input()))
x=int(input())
print(firstIndex(arr,0,x))
