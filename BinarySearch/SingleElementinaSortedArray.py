class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        n=len(nums)
        if n==1 or (nums[0]!=nums[1]):
            return nums[0]
        if nums[n-1]!=nums[n-2]:
             return nums[n-1]
        low=0
        high=n-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid] != nums[mid-1] and nums[mid]!=nums[mid+1]:
                return nums[mid]
                
            elif nums[mid]==nums[mid-1]:
                lo=mid-low+1
                if lo%2==0:
                    low=mid+1
                else:
                    high=mid-2
            elif nums[mid]==nums[mid+1]:
                hi=high-mid+1
                if hi%2==0:
                    high=mid-1
                else:
                    low=mid+2
        
#tc=o(logn)
#sc=o(1)
#ide :https://leetcode.com/problems/single-element-in-a-sorted-array/
#solutionvideo: https://www.youtube.com/watch?v=WFNa5o-dHGo&t=1464s
