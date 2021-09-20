def displayArr(arr,n):
    if n==0:
        return
    print(arr[n-1])
    displayArr(arr,n-1)
    print(arr[n-1])
    

n=int(input())
arr=[]
for i in range(n):
    arr.append(int(input()))
displayArr(arr,n)
