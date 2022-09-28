//Method-1

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        
        prefix[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        
        
        suffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }
        
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return waterTrapped;
      
    }
}

//Time Complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array.
//Space Complexity: O(N)+O(N) for prefix and suffix arrays.


//Method-2

class Solution {
    public int trap(int[] height) {
      int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }
}


//Time Complexity: O(N) because we are using 2 pointer approach.
//Space Complexity: O(1) because we are not using anything extra.
