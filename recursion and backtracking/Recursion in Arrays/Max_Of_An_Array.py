import sys
sys.setrecursionlimit(10**6)
def maxArr(arr,idx):
    if idx==0:
        return arr[0]
    a=maxArr(arr,idx-1)
    if a>arr[idx]:
        return a
    else:
        return arr[idx]
n=int(input())
arr=[]
for i in range(0,n):
    arr.append(int(input()))
print(maxArr(arr,n-1))

# sys.setrecursionlimit() method is used to set the maximum depth of the Python interpreter stack to the required limit. This limit prevents any program from getting into infinite recursion, Otherwise infinite recursion will lead to overflow of the C stack and crash the Python.

# Note: The highest possible limit is platform-dependent. This should be done with care because too-high limit can lead to crash.


# The sys module in Python provides valuable information about the Python interpreter. You can also use it to obtain details about the constants, functions and methods of the Python interpreter.
