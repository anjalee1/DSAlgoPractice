
n=int(input())
arr=[]
for i in range(n):
    arr.append(int(input()))
amt=int(input())

dp=[0]*(amt+1)
dp[0]=1
for i in range(len(arr)):
    for j in range(arr[i],len(dp)):
        dp[j] +=dp[j-arr[i]]
print(dp[amt])
