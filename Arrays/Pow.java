
//ide :https://leetcode.com/problems/powx-n/
//sol:https://www.youtube.com/watch?v=l0YC3876qxg&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=18
//https://takeuforward.org/data-structure/implement-powxn-x-raised-to-the-power-n/


// Time Complexity: O(log n)
// Space Complexity: O(1)


class Solution {
    public double myPow(double x, int n) {
         double ans = 1.0;
        long nn = n;
        if (nn < 0) nn = -1 * nn;
        while (nn > 0) {
        if (nn % 2 == 1) {
            ans = ans * x;
            nn = nn - 1;
        } else {
            x = x * x;
            nn = nn / 2;
        }
        }
        if (n < 0) ans = (double)(1.0) / (double)(ans);
        return ans;
    }
}
