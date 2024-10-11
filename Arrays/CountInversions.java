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

class Solution {

    static long merge(long arr[], long left, long mid, long right) {
        long inv_count = 0;
        int i = (int)left;
        int j = (int)(mid + 1);
        ArrayList<Long> temp = new ArrayList<>();

        // Merge two halves and count inversions
        while (i <= (int)mid && j <= (int)right) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);
                inv_count += (mid - i + 1);
            }
        }

        // Copy remaining elements from left half
        while (i <= (int)mid) {
            temp.add(arr[i++]);
        }

        // Copy remaining elements from right half
        while (j <= (int)right) {
            temp.add(arr[j++]);
        }

        // Copy the sorted elements back into the original array
        for (int k = (int)left; k <= (int)right; k++) {
            arr[k] = temp.get(k - (int)left); // Ensure correct index calculation
        }

        return inv_count;
    }

    static long mergeSort(long[] nums, long low, long high) {
        if (low >= high) return 0;
        long mid = (low + high) / 2;
        long inv = mergeSort(nums, low, mid);
        inv += mergeSort(nums, mid + 1, high);
        inv += merge(nums, low, mid, high);
        return inv;
    }

    static long inversionCount(long arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }


}
