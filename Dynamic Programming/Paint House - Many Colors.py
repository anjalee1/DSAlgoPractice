import sys
n,c=map(int,input().split())
arr=[]
for i in range(n):
    string=input().split()
    a=[]
    for x in string:
        a.append(int(x))
    arr.append(a)

dp=[]
for i in range(n):
    a=[]
    for j in range(c):
        a.append(0)
    dp.append(a)
    
least = sys.maxsize
sleast= sys.maxsize

for j in range(len(arr[0])):
    dp[0][j]=arr[0][j]
    if arr[0][j]<= least:
        sleast =least
        least=arr[0][j]
    elif arr[0][j]<=sleast:
        sleast=arr[0][j]
    

for i in range(1,len(dp)):
    nleast= sys.maxsize
    nsleast=sys.maxsize
    for j in range(len(dp[0])):
        if least==dp[i-1][j]:
            
            dp[i][j]=arr[i][j]+sleast
    
        else:

            dp[i][j]=arr[i][j]+least
            
        if dp[i][j]<=nleast:
            nsleast =nleast
            nleast=dp[i][j]
        elif dp[i][j]<=nsleast:
            nsleast=dp[i][j]
    least=nleast
    sleast=nsleast
    
print(least)
