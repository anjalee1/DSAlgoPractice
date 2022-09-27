//Time Complexity: O(N) since the solution involves only a single pass.
//Space Complexity: O(1) because no extra space is used.

// ide: https://leetcode.com/problems/max-consecutive-ones/
//videoSol: https://www.youtube.com/watch?v=Mo33MjjMlyA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=45


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            maxi = Math.max(maxi, cnt);
         }
        return maxi;
    }
}
