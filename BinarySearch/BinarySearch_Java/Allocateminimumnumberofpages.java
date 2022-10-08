
//ide:https://www.codingninjas.com/codestudio/problems/allocate-books_1090540
//sol:https://www.youtube.com/watch?v=okP-e2VpI_g
// Time Complexity : O(NlogN)
// Reason: Binary search takes O(log N). For every search, we are checking if an allocation is possible or not. Checking for allocation takes O(N).
// Space Complexity: O(1)
// Reason: No extra data structure is used to store spaces.

import java.util.* ;
import java.io.*; 
public class Solution {
    
    
    public static boolean isPossible(ArrayList<Integer> arr, int mid, int m) {
    int st = 1;
    int sum = 0;
    for (int i = 0; i < arr.size(); i++) {
      sum += arr.get(i);
      if (sum > mid) {
        sum = arr.get(i);
        st++;
      }
    }
    return st <= m;
  }

    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        if (m > arr.size()) return -1;

        int sum = 0;
        int max = 0;
        for (Integer val : arr) {
          sum += val;
          max = Math.max(max, val);
        }

        int lo = max;
        int hi = sum;
        int ans = 0;

        while (lo <= hi) {
          int mid = lo + (hi - lo) / 2;

          if (isPossible(arr, mid, m) == true) {
            ans = mid;
            hi = mid - 1;
          }
          else {
            lo = mid + 1;
          }
        }

        return ans;
    }
}
