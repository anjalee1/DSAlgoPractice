n=int(input())
arr=[]
for i in range(n):
    arr.append(int(input()))
tar=int(input())
dp=[]
for i in range(n+1):
    ax=[]
    for j in range(tar+1):
        ax.append("false")
    dp.append(ax)
for i in range(len(dp)):
    for j in range(len(dp[0])):
        if i==0 and j==0:
            dp[i][j]="true"
        elif i==0:
            dp[i][j]="false"
            
        elif j==0:
            dp[i][j]="true"
            
        else:
            if dp[i-1][j]=="true":
                dp[i][j]="true"
            else:
                val=arr[i-1]
                if j>=val:
                    if dp[i-1][j-val]=="true":
                        dp[i][j]="true"
print(dp[len(arr)][tar])
