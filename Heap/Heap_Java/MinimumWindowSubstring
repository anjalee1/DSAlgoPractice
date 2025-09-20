//https://leetcode.com/problems/minimum-window-substring/
//https://www.youtube.com/watch?v=WJaij9ffOIY
//Time: O(|s| + |t|) — building the need map costs O(|t|). Each right index is processed once; each left index moves at most once, so overall linear in |s|.

Space: O(k) where k is the number of distinct characters in t (the need map).

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        // Build frequency map for t (the only map we use)
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int total = t.length(); // total number of characters (including duplicates) we must match
        int matched = 0; // how many characters from t (counting duplicates) we've matched in the window

        int left = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestLeft = 0;

        // Expand window by moving 'right'
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            if (need.containsKey(rc)) {
                // If this char was still required (>0) then we've matched one more required char
                if (need.get(rc) > 0) {
                    matched++;
                }
                // consume this char from the requirement
                need.put(rc, need.get(rc) - 1);
            }

            // When we have matched all required characters, try to shrink from left
            while (matched == total) {
                // Update best window
                int windowLen = right - left + 1;
                if (windowLen < bestLen) {
                    bestLen = windowLen;
                    bestLeft = left;
                }

                // Remove the leftmost char from window and update map/matched accordingly
                char lc = s.charAt(left);
                if (need.containsKey(lc)) {
                    // return the char back to need (we increment count)
                    need.put(lc, need.get(lc) + 1);
                    // if after returning the char the need count is > 0, we lost a required char
                    if (need.get(lc) > 0) {
                        matched--;
                    }
                }
                left++; // shrink window
            }
        }

        return (bestLen == Integer.MAX_VALUE) ? "" : s.substring(bestLeft, bestLeft + bestLen);
    }
}
