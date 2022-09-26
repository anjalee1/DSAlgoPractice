
// tc=o(log(n))
// #solutionvideo = https://www.youtube.com/watch?v=1uu3g_uu8O0&t=832s
// #ide=https://leetcode.com/problems/search-in-rotated-sorted-array/



class Solution {
    public int search(int[] nums, int target) {
        
        int lo=0;
        int hi=nums.length-1;
        
        while(lo<=hi){
            int mid =lo+(hi-lo)/2;
            if(nums[mid]==target){
                return mid;
            }
            
            else if(nums[lo]<=nums[mid]){
                if(target>=nums[lo] && nums[mid]>target){
                    hi=mid-1;
            
                }
            
                else{
                    lo=mid+1;
                    
                }
          }
            
          else if(nums[mid]<=nums[hi]){
                if(target>nums[mid] && nums[hi]>=target){
                    lo=mid+1;
            
                }
            
                else{
                    hi=mid-1;
                }
          }       
        
    }
    
    return -1;
  }
}
