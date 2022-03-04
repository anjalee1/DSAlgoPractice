
from sys import stdin
from collections import deque
def display(arr) :
	for i in range(len(arr)) :
		print(arr[i], end = "\n")
def solve(arr2):
    st=deque()
    arr=[0]*len(arr2)
    arr[-1]=-1
    st.append(arr2[-1])
    for i in range(len(arr2)-2,-1,-1):
        while len(st)>0 and arr2[i]>=st[-1]:
            st.pop()
        if len(st)==0:
            arr[i]=-1
        else:
            arr[i]=st[-1]
        st.append(arr2[i])
    return arr
            

n = int(input())
arr =[]
for i in range (n):
    x = int(input())
    arr.append(x)

nge = solve(arr)
display(nge)
