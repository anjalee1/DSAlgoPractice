import sys 
sys.setrecursionlimit(10**6)
def lastIndex(arr,idx,x):
    if idx==len(arr):
        return -1
    liisa=lastIndex(arr,idx+1,x)
    if liisa ==-1:
        if arr[idx]==x:
            return idx
        else:
            return -1
    else:
        return liisa
n=int(input())
arr=[]
for i in range(0,n):
    arr.append(int(input()))
x=int(input())
print(lastIndex(arr,0,x))
