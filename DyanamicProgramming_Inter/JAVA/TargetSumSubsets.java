//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
       
       boolean[][] dp = new boolean[N+1][sum +1];
       
       for(int i=0; i<dp.length;i++){
           for(int j =0; j<dp[0].length;j++){
               
               if(i==0 && j==0){
                   dp[i][j]=true;
               }
               else if(i==0){
                     dp[i][j]=false;
               }
               else if(j==0){
                    dp[i][j]=true;
               }
               else{
                   
                   if(dp[i-1][j]==true){
                       dp[i][j]=true;
                   }
                   else{
                   int val =arr[i-1];
                   if(j>=val){
                       if(dp[i-1][j-val]==true){
                           dp[i][j] =true;
                       }
                   }
                 }
               }
               
           }
       }
       
       return dp[arr.length][sum];
    }
}

//ide:https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//sol:https://www.youtube.com/watch?v=tRpkluGqINc&t=1536s

//tc: O(N*K)
//sc: O(N*K)
