n=int(input())
arr=[]
for i in range(n):
    arr.append(int(input()))
inc=arr[0]
exc=0
for i in range(1,n):
    ninc=exc+arr[i]
    nexc=max(inc,exc)
    inc=ninc
    exc=nexc
print(max(inc,exc))
