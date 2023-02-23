//ide:https://leetcode.com/problems/climbing-stairs/description/
//sol:https://www.youtube.com/watch?v=uNqoQ0sNZCM&t=6s
//tc:o(n), sc:o(n)

class Solution {
    public int climbStairs(int n) {
       
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i >= 1){
              dp[i] += dp[i - 1];
            }
            if(i >= 2){
             dp[i] += dp[i - 2];
            }
        }
        return dp[n];
        
    }
}
