class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0 && n > 0){for(int i = 0; i < n; i++) nums1[i] = nums2[i]; }//if nums1 is empty, copy from nums2
        
        else if(n == 0){ //no need to copy, nums2 is empty anyways
        
        }
        else{
         int i, k;
        for (i = 0; i < m; i++) {
       
            if (nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
            
                int first = nums2[0];
                // insertion sort is used here
                for (k = 1; k < n && nums2[k] < first; k++) {
                    nums2[k - 1] = nums2[k];
                }
                nums2[k - 1] = first;
            }
      } 
      int j=m;
      for(i=0;i<n;i++){
          nums1[j++]=nums2[i];
      }
    }

}
}

//ide:https://leetcode.com/problems/merge-sorted-array/description/
//sol: https://www.youtube.com/watch?v=hVl2b3bLzBw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=5

//Time complexity: O(m*n)
//Space Complexity: O(1) 
