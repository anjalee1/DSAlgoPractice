//ide:https://leetcode.com/problems/majority-element/description/
//sol:https://www.youtube.com/watch?v=AoX3BPWNnoE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=18
//https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/

//Time Complexity: O(N)
//Space Complexity: O(1)

class Solution {
    public int majorityElement(int[] nums) {
         int count = 0;
         int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if(num==candidate)
            count += 1; 
            else count -= 1; 
        }

        return candidate;
    }
}
