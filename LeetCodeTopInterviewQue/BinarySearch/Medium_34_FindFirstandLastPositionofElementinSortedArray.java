//ide : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
//tc: o(logn)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low,high,mid,ans1=-1;
        low = 0;
        high = nums.length-1;
        
        while(low<=high)
        {
            mid = (low+high)/2;
            if(nums[mid] == target)
            {
                ans1 = mid;
                high = mid-1; // To get the first occurence of the element 
            }
            else if(nums[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        
        low = 0;
        high = nums.length-1;
        int ans2=-1;
        
        while(low<=high)
        {
            mid = (low+high)/2;
            if(nums[mid] == target)
            {
                ans2 = mid;
                low = mid+1; // To get the last occurence of the element
            }
            else if(nums[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }
        
        return new int[]{ans1,ans2};
    }
}
