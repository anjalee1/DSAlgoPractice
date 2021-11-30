
n=int(input())
m=int((input()))
list1=[]
for i in range(n):
   
    x=input()
    
    list1.append(list(map(int,x.split())))
dp=[] 
    
for i in range(n):
    b = []
    for  j in range(m):
        b.append(0)
    dp.append(b)

for i in range(len(dp)-1,-1,-1):
    for j in range(len(dp[0])-1,-1,-1):
        if i==len(dp)-1 and j==len(dp[0])-1:
            dp[i][j]=list1[i][j]
        elif i==len(dp)-1:
            dp[i][j]=dp[i][j+1]+list1[i][j]
        elif j==len(dp[0])-1:
            dp[i][j]=dp[i+1][j]+list1[i][j]
        else:
            dp[i][j]=min(dp[i+1][j],dp[i][j+1])+list1[i][j]
            
print(dp[0][0])
