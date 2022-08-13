class Solution:
    def search(self, nums: List[int], target: int) -> int:
        lo=0
        hi=len(nums)-1
        while lo<=hi:
            mid=lo+(hi-lo)//2
            if nums[mid]==target:
                return mid
            #lo to mid is sorted
            elif nums[mid]>=nums[lo]:
              if target>=nums[lo] and target<nums[mid]:
                hi=mid-1
              else:
               lo=mid+1
            #mid to high is sorted 
            elif nums[mid]<nums[hi]:
             if target<=nums[hi] and target>nums[mid]:
                lo=mid+1
             else:
                hi=mid-1
        return -1
            
#tc=o(log(n))
#solutionvideo = https://www.youtube.com/watch?v=1uu3g_uu8O0&t=832s
#ide=https://leetcode.com/problems/search-in-rotated-sorted-array/
