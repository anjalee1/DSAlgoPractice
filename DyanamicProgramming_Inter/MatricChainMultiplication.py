import sys
def matrixChainMultiplication(arr):
    n = len(arr)
    dp = [[0 for col in range(n-1)] for row in range(n-1)]
    for gap in range(0, len(dp)):
        si = 0
        ei = gap
        while ei < len(dp):
            if gap == 0:
                dp[si][ei] = 0
            elif gap == 1:
               dp[si][ei] = arr[si]*arr[ei]*arr[ei+1]
            else:
                minm=sys.maxsize
                for k in range(si,ei):
                    lc=dp[si][k]
                    rc=dp[k+1][ei]
                    mc=arr[si]*arr[k+1]*arr[ei+1]
                    minm=min(minm,lc+rc+mc)
                dp[si][ei]=minm

            si = si + 1
            ei = ei + 1
    return dp[0][len(dp)-1]



def main():
    n= int(input())
    arr=[]
    for i in range(n):
        arr.append(int(input()))
    print(matrixChainMultiplication(arr))

if __name__ == "__main__":
    main()
