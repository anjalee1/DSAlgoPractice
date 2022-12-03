class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
        
    }
}

//ide: https://leetcode.com/problems/valid-anagram/
//sol:https://www.youtube.com/watch?v=QZmh8-Auqo8
//https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
//https://leetcode.com/problems/valid-anagram/discuss/66484/Accepted-Java-O(n)-solution-in-5-lines

//tc: o(N);
//sc: o(26);
