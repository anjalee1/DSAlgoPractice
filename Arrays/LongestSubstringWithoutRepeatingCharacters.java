//Time Complexity: O( N )
//Space Complexity: O(N) where N represents the size of HashSet where we are storing our elements


//IDE:https://leetcode.com/problems/longest-substring-without-repeating-characters/
//sol: https://www.youtube.com/watch?v=qtVh-XEpsJo&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=28
//https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left); // dry run "abba" to understand Math.max() is used
            mpp.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
 
