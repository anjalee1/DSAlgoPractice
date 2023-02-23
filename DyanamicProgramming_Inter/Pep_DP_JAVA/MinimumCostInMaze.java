//ide: https://leetcode.com/problems/minimum-path-sum/description/
//sol:https://www.youtube.com/watch?v=BzTIOsC0xWM&t=1s

//tc:o(n^2),sc:o(n^2)

class Solution {
    public int minPathSum(int[][] grid) {
        
        int r =grid.length;
        int c= grid[0].length;

        int dp[][]=new int[r][c];
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                if(i==r-1 && j==c-1){
                   dp[i][j]=grid[i][j];
                }
                else if(i==r-1){
                  dp[i][j]=dp[i][j+1]+grid[i][j];
                }
                else if(j==c-1){
                    dp[i][j]=dp[i+1][j]+grid[i][j];
                }
                else{
                   dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
                }
            }
        }

        return dp[0][0];
        
    }
}

