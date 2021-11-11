import sys
def fun(n, jumps, dp):
  dp[n]=0
  for i in range(n-1,-1,-1):
    if jumps[i]>0:
      minm=sys.maxsize
      for j in range(1,jumps[i]+1):
        if i+j<len(dp) and dp[i+j]!=None:
                minm=min(minm,dp[i+j])
      if minm!=sys.maxsize:
        dp[i]=minm+1


  return dp[0]

# driver code
def main():
    n = int(input())

    jumps = []

    for i in range(n) :
        jumps.append(int(input()))

    dp = [None] * (n + 1)

    ans = fun( n, jumps, dp)

    if (ans < 30):
             print(ans)
    else:
            print("null")

if __name__ == "__main__":
    main()
