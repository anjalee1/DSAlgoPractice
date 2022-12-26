//ide: https://leetcode.com/problems/palindrome-partitioning/
//sol: https://www.youtube.com/watch?v=WBgsABoClE0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=52
//https://takeuforward.org/data-structure/palindrome-partitioning/


//Time Complexity: O( (2^n) *k*(n/2) )
//Space Complexity: O(k * x)

class Solution {
    public List<List<String>> partition(String s) {
        List < List < String >> res = new ArrayList < > ();
        List < String > path = new ArrayList < > ();
        partitionHelper(0, s, path, res);
        return res;
          
    }


    void partitionHelper(int index, String s, List < String > path, List < List < String >> res) {
        if (index == s.length()) {
            res.add(new ArrayList < > (path));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                partitionHelper(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
