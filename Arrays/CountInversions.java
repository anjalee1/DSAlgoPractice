//ide:https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//sol:https://www.youtube.com/watch?v=kQ1mJlwW-c0

//tc:nlogn
//sc:o(n)

//reason for using explicit casting for indices of array : https://stackoverflow.com/questions/27333879/can-you-index-an-array-with-a-long-int


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long merge(long arr[],long temp[],long left,long mid,long right)
    {
        long inv_count=0;
        long i = left;
        long j = mid;
        long k = left;
        while((i <= mid-1) && (j <= right)){
            if(arr[(int)i] <= arr[(int)j]){
                temp[(int)k++] = arr[(int)i++];
            }
            else
            {
                temp[(int)k++] = arr[(int)j++];
                inv_count = inv_count + (mid - i);
            }
        }
    
        while(i <= mid - 1)
            temp[(int)k++] = arr[(int)i++];
    
        while(j <= right)
            temp[(int)k++] = arr[(int)j++];
    
        for(i = left ; i <= right ; i++)
            arr[(int)i] = temp[(int)i];
        
        return inv_count;
    }
    
    static long merge_Sort(long arr[],long temp[],long left,long right)
    {
        long mid,inv_count = 0;
        if(right > left)
        {
            mid = (left + right)/2;
    
            inv_count += merge_Sort(arr,temp,left,mid);
            inv_count += merge_Sort(arr,temp,mid+1,right);
    
            inv_count += merge(arr,temp,left,mid+1,right);
        }
        return inv_count;
    }

    static long inversionCount(long arr[], long N)
    {
        long[] temp = new long[(int)N];
        long ans = merge_Sort(arr,temp,0,N-1);
        return ans;
    }
}
