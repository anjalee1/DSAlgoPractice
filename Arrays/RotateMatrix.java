class Solution {
    public void rotate(int[][] matrix) {
         for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}

//ide:https://leetcode.com/problems/rotate-image/description/
//sol:https://www.youtube.com/watch?v=Y72QeX0Efxw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=13
//https://takeuforward.org/data-structure/rotate-image-by-90-degree/

// Time Complexity: O(N*N) + O(N*N).One O(N*N) for transposing the matrix and the other for reversing the matrix.
// Space Complexity: O(1).
