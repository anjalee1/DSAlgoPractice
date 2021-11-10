
def fun(n, dp):
 dp[0]=0
 dp[1]=1
 for i in range(2,n+1):
    dp[i]=dp[i-1]+dp[i-2]
    
 return dp[n] 

  
def main():
    n = int(input())
    dp = [0] * (n + 1)
    print(fun(n, dp));

if __name__ == "__main__":
  main()
