
//ide: https://practice.geeksforgeeks.org/problems/form-a-palindrome2544/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//sol: https://www.youtube.com/watch?v=IP4iqrh0mQk&t=199s

//tc: o(n^2)
//sc: o(n^2)

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
      
        int len = S.length();
        int[][] dp = new int[len][len];
        int max = 0;
        for(int gap = 0; gap < dp.length; gap++) {
            for(int si = 0,ei=gap; ei <dp.length; si++,ei++) {
                if(gap==0){
                  dp[si][ei] = 1;  
                    
                }
                else{
                     if(S.charAt(si) == S.charAt(ei)) {
                      dp[si][ei] = dp[si+1][ei-1]+2;   
                    }
                    
                    else{
                      dp[si][ei] = Math.max(dp[si+1][ei],dp[si][ei-1]);    
                    }
                    
                }
            }
        }
       int ans =len - dp[0][dp.length-1];
       return ans;
    }
}
