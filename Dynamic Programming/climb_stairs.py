def fun(n, dp):
    dp[0]=1
    for i in range(1,n+1):
        if i ==1:
            dp[i]= dp[i-1]
        elif i==2:
            dp[i]=dp[i-1]+dp[i-2]
        else:
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3]
    return dp[n]


# driver code
def main():
   n = int(input())
   dp = [0] * (n + 1)
   print(fun(n, dp))

if __name__ == "__main__":
    main()
