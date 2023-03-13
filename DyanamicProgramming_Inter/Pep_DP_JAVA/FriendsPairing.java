//ide:https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1
//sol: https://www.youtube.com/watch?v=SHDu0Ufjyk8&t=109s

//tc:o(n)
//sc:o(1)

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int m = 1000000007;
    public long countFriendsPairings(int n) 
    { 
        long a = 1, b = 2, c = 0; 
    	if (n <= 2) { 
    		return n; 
    	} 
    	for (int i = 3; i <= n; i++)
    	{ 
    	    // using modular arithmentic properties.
    		c = ( b%m + ( ( (i - 1)%m  *  a%m )%m ) %m )%m ; 
    		a = b; 
    		b = c; 
    	} 
    	return c; 
    }
}    
 
