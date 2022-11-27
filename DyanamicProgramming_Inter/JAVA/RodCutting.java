//ide: https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
//sol: https://www.youtube.com/watch?v=eQuJb5gBkkc
//tc:O(N*N)
//sc: O(N*N)



//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
          
        int[] dp =new int[price.length+1];
        dp[0] =0;
        dp[1] =price[0];
        
        for(int i=2;i<dp.length;i++){
            dp[i]=price[i-1];
            
            int li=1;
            int ri=i-1;
            
            while(li<=ri){
                if(dp[li]+dp[ri] >dp[i]){
                    dp[i]=dp[li]+dp[ri];
                    
                }
                
                li++;
                ri--;
            }
        }
        
        return dp[dp.length-1];
        
    }
}
