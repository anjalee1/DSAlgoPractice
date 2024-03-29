//ide: https://leetcode.com/problems/super-egg-drop/
//sol: https://www.youtube.com/watch?v=UvksR0hR9nA
//https://leetcode.com/problems/super-egg-drop/discuss/2999392/Java(DP)-Solution-with-
//https://leetcode.com/problems/super-egg-drop/discuss/1960138/java-solution

//tc:
//sc: 



class Solution {
    public int superEggDrop(int n, int k) {
        int [][] dp = new int[n+1][k+1];
        int m = 0;
        while (dp[n][m] < k) {
            m += 1;
            for (int egg=1; egg<=n; egg++) {
                dp[egg][m] = dp[egg][m-1] + dp[egg-1][m-1] + 1;
            }
        }
        return m;
    }
}
