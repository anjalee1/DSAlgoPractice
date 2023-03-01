//ide:https://leetcode.com/problems/coin-change-ii/
//sol:https://www.youtube.com/watch?v=l_nR5X9VmaI&t=2s
//tc:o(n^2)
//sc:o(n)
class Solution {
    public int change(int amount, int[] coins) {
        
        int dp[]= new int[amount+1];
         dp[0]=1;
        for(int i =0;i<coins.length;i++){
            for(int j =coins[i];j<dp.length;j++){
                dp[j]+=dp[j-coins[i]];

            }
        }

        return dp[amount];
    }
}
