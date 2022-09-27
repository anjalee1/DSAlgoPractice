
//ide:https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//videoSol: https://www.youtube.com/watch?v=Fm_p9lJ4Z_8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=44

class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length==0){
            return 0;
        }
        
        int i=0;
        
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i]=nums[j];
                
            }
        }
        
        return i+1;
        
    }
}

//Time complexity: O(n)
//Space Complexity: O(1)
