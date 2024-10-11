//gfg variation =>https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/


//ide:https://leetcode.com/problems/search-a-2d-matrix/description/
//sol:https://www.youtube.com/watch?v=JXU4Akft7yk
//https://takeuforward.org/data-structure/count-inversions-in-an-array/

//Time complexity: O(log(m*n))
//Space complexity: O(1)





class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int lo = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length; 
        int m = matrix[0].length; 
        int hi = (n * m) - 1;
        
        while(lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
        
    }
}
