//ide: https://www.codingninjas.com/codestudio/problems/1112629?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
//sol: https://www.youtube.com/watch?v=nv7F4PiLUzo&t=380s  (mistake in edge cases due to position of m and n)

// Time Complexity : log(min(m,n))
// Reason: We are applying binary search in the array with minimum size among the two. And we know the time complexity of the binary search is 
// log(N) where N is the size of the array. Thus, the time complexity of this approach is log(min(m,n)), where m,n are the sizes of two arrays.

// Space Complexity: O(1)
// Reason: Since no extra data structure is used, making space complexity to O(1).


public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
       if(m > n) {
        return ninjaAndLadoos(row2, row1, n, m, k); 
    }
        
    int low = Math.max(0,k-n), high = Math.min(k,m);
        
    while(low <= high) {
        int cut1 = (low + high) >> 1; 
        int cut2 = k - cut1; 
        int l1 = cut1 == 0 ? Integer.MIN_VALUE : row1[cut1 - 1]; 
        int l2 = cut2 == 0 ? Integer.MIN_VALUE : row2[cut2 - 1];
        int r1 = cut1 == m? Integer.MAX_VALUE : row1[cut1]; 
        int r2 = cut2 == n ? Integer.MAX_VALUE : row2[cut2]; 
            
        if(l1 <= r2 && l2 <= r1) {
            return Math.max(l1, l2);
        }
        else if (l1 > r2) {
            high = cut1 - 1;
        }
        else {
            low = cut1 + 1; 
        }
    }
    return -1;
    }
}
