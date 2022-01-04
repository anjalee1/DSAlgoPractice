string=input()
dp=[0]*(len(string)-1)
dp[0]=1
for i in range(1,len(dp)):
    if string[i-1]=="0" and string[i]=="0":
        dp[i]=0
    elif string[i-1]!="0" and string[i]=="0":
        if string[i-1]=="1" or string[i-1]=="2":
            dp[i]= (dp[i-2] if i>=2 else 1)
        else:
            dp[i]=0
    elif string[i-1]=="0" and string[i]!="0":
        dp[i]=dp[i-1]
    else:
        if int(string[i-1:i+1])<=26:
            dp[i]=dp[i-1]+ (dp[i-2] if i>=2 else 1)
        else:
            dp[i]=dp[i-1]
print(dp[len(dp)-1])
