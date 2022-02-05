
import sys
def kTransactions(arr,n,k):
   dp=[[0 for i in range(n)] for j in range(k+1)]
   for t in range(1,k+1):
     max =-sys.maxsize
     for d in range(1,len(arr)):
         if dp[t-1][d-1]-arr[d-1]>max:
             max=dp[t-1][d-1]-arr[d-1]
         if max+arr[d]>dp[t][d-1]:
             dp[t][d]=max+arr[d]
         else:
             dp[t][d]=dp[t][d-1]
   print(dp[k][n-1])




    
def main():
    n = int(input())
    array = []
    for i in range(n):
        array.append(int(input()))

    k = int(input())
    kTransactions(array,n,k)

if __name__ == '__main__':
    main()
    
