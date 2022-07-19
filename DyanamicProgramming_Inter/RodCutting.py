def rodCuttingMaxProfit(prices):
    dp=[0]*len(prices)
    dp[1]=prices[1]
    for i in range(2,len(prices)):
        dp[i]=prices[i]
        le=1
        ri=i-1
        while le<=ri:
            dp[i]=max(dp[le]+dp[ri],dp[i])
            le=le+1
            ri=ri-1
    return dp[len(prices)-1]

def main():
    n=int(input())
    prices=[]
    prices.append(0)
    for i in range(n):
        prices.append(int(input()))
    print(rodCuttingMaxProfit(prices))

if __name__=="__main__":
    main()
