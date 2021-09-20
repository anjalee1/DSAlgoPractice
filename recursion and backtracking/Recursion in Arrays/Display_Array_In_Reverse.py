def revArray(arr,n):
    if n==0:
        return
    print(arr[n-1])
    revArray(arr,n-1)
    

n=int(input())
arr=[]
for i in range(n):
    arr.append(int(input()))
revArray(arr,n)
