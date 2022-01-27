
n=int(input())
k=int(input())
if n==0 or k==0 or n<k:
    print(0)
    
dp=[]
for t in range(k+1):
    a=[]
    for p in range(n+1):
        a.append(0)
    dp.append(a)



for t in range(1,k+1):
    for p in range(1,n+1):
        if p<t:
            dp[t][p]=0
        elif p==t:
            dp[t][p]=1
        else:
            dp[t][p]=dp[t-1][p-1]+dp[t][p-1]*t
    
print(dp[t][p])
