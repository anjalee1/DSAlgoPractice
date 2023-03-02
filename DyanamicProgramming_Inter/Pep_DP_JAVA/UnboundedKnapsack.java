
//ide : https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//sol: https://www.youtube.com/watch?v=jgps7MXtKRQ&t=118s

//tc: o(W*n)
//sc: o(W)

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[] = new int[W+1];
        dp[0]=0;
        for(int bagc=1;bagc<=W;bagc++){
            int max=0;
             for(int i=0;i<N;i++){
                if(wt[i]<=bagc){
                    
                    int rbagc = bagc-wt[i];
                    int rbagv=dp[rbagc];
                    int tbagv=rbagv+val[i];
                    
                    if(tbagv>max){
                        max=tbagv;
                    }
                    
                }
             }
             
             dp[bagc]=max;
        }
        
        return dp[W];
        
    }
}
