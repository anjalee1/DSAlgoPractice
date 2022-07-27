def EditDistance(str1,str2):
    col=len(str2)+1
    row=len(str1)+1
    dp=[[0 for j in range(0,col)] for i in range(0,row)]

    for i in range(0,len(dp)):
        for j in range(0,len(dp[0])):
            if i==0:
                dp[i][j]=j
            elif j==0:
              dp[i][j]=i
            else:
                if (str1[i-1]==str2[j-1]):
                    dp[i][j]=dp[i-1][j-1]
                else:
                    f1=1+dp[i][j-1] #insert
                    f2=1+dp[i-1][j] #delete
                    f3=1+dp[i-1][j-1]#replace
                    dp[i][j]=min(f3,min(f1,f2))
    return dp[len(dp)-1][len(dp[0])-1]
    






str1=input()
str2=input()

print(EditDistance(str1.strip(),str2.strip()))
