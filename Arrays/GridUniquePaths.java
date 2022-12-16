//IDE:https://leetcode.com/problems/unique-paths/description/
//SOL:https://www.youtube.com/watch?v=t_f0nwwdg5o
//https://takeuforward.org/data-structure/grid-unique-paths-count-paths-from-left-top-to-the-right-bottom-of-a-matrix/

//Time Complexity: The time complexity of this solution will be O(n-1) or  O(m-1) depending on the formula we are using.
//Space Complexity: As we are not using any extra space the space complexity of the solution will be  O(1).


class Solution {
    public int uniquePaths(int m, int n) {
            int N = n + m - 2;
            int r = m - 1; 
            double res = 1;
            
            for (int i = 1; i <= r; i++)
                res = res * (N - r + i) / i;
            return (int)res;
    }
}
