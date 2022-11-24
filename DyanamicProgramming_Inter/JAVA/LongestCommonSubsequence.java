class Solution {
    // Tabulation (DP) #9 ms
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i -1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        
        return dp[n][m];
    }
}
    

//ide:https://leetcode.com/problems/longest-common-subsequence/
//sol:https://www.youtube.com/watch?v=0Ql40Llp09E&t=382s

// Time Complexity: O(N*M)
// Reason: There are two nested loops
// Space Complexity: O(N*M)
// Reason: We are using an external array of size ‘N*M)’. Stack Space is eliminated.
