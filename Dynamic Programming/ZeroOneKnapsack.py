n=int(input())

vals=input().split()
wts=input().split()
v=[]
w =[]
for x in vals:
    v.append(int(x))

for y in wts:
    w.append(int(y))
    
cap=int(input())    
dp=[]
for i in range(n+1):
    a=[]
    for j in range(cap+1):
        a.append(0)
    dp.append(a)


for i in range(1,len(dp)):
    for j in range(1,len(dp[0])):
        if j>=w[i-1]:
            rcap=j-w[i-1]
            if dp[i-1][rcap]+v[i-1]>dp[i-1][j]:
                dp[i][j]=dp[i-1][rcap]+v[i-1]
            else:
                dp[i][j]=dp[i-1][j]
        else:
            dp[i][j]=dp[i-1][j]
print(dp[n][cap])
