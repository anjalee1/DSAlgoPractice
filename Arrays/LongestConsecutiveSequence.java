//Time Complexity: The time complexity of the above approach is O(N) because we traverse each consecutive subsequence only once. (assuming hashset takes O(1) to search)
//Space Complexity: The space complexity of the above approach is O(N) because we are maintaining a HashSet.

//ide:https://leetcode.com/problems/longest-consecutive-sequence/description/
//sol: https://www.youtube.com/watch?v=qgizvmgeyUM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=24
//https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num: nums) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
