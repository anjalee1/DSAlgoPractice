
def LongestIncreasingSubsequence(arr):
    dp=[0]*len(arr)
    om=0
    for i in range(0,len(dp)):
        max=0
        for j in range(0,i):
            if arr[j]<arr[i] and dp[j]>max:
                max=dp[j]
        dp[i]=max+1
        if dp[i]>om:
            om=dp[i]
    print(om)

def main():
    n=int(input())
    arr=[]
    for i in range(n):
        arr.append(int(input()))
    LongestIncreasingSubsequence(arr)
    

if __name__ == "__main__":
    main()
