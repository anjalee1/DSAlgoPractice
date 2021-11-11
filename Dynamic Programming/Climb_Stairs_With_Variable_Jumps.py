
def fun(n, arr, dp):

    dp[n]=1
    for i in range(n-1,-1,-1):
      for j in range(1,arr[i]+1):
        if i+j<len(dp):
            dp[i] += dp[i+j]
    return dp[0]


# driver code
def main():
  n = int(input())
  arr = []

  for i in range(0, n) :
        arr.append(int(input()))

  dp = [0] * (n + 1)

  print(fun(n, arr, dp))

if __name__ == "__main__":
         main()
