Time Complexity: O(N*T)
Reason: There are two nested loops.
Space Complexity: O(T)
Reason: We are using an external array of size ‘T+1’ to store two rows only.
//ide: https://practice.geeksforgeeks.org/problems/coin-change2448/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    
//sol:https://www.youtube.com/watch?v=l_nR5X9VmaI
    
    
    //{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        long [] dp = new long[sum+1];
        dp[0] =1;
        
        for(int i=0 ;i<N;i++){
            for(int j=coins[i];j<dp.length;j++){
                
                dp[j] += dp[j-coins[i]];
                
            }
        }
        
        return dp[sum];
    }
}



