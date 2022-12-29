//ide:https://leetcode.com/problems/sudoku-solver/
//sol: https://www.youtube.com/watch?v=FWAIf_EVUKE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=59
//https://takeuforward.org/data-structure/sudoku-solver/

//Time Complexity: O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.
//Space Complexity: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {

            for (char c = '1'; c <= '9'; c++) {
                if (isValid(board, i, j, c)) {
                board[i][j] = c;

                if (solve(board))
                    return true;
                else
                    board[i][j] = '.';
                }
            }

            return false;
            }
        }
        }
        return true;
    }

   public boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == c)
        return false;

      if (board[row][i] == c)
        return false;

      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
        return false;
    }
    return true;
  }
}
