public class Solution {
    /**
     *  Straightforward backtracking
     *  Time complexity -> O(c^n), where c is a constant
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int i, int j) {
        if (i == 9 && j == 0) return true;
        if (board[i][j] != '.') return solve(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);
        
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, i, j, ch)) {
                board[i][j] = ch;
                if (solve(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1)) return true;
                board[i][j] = '.';
            }
        }
        
        return false;
    }
    
    private boolean isValid(char[][] board, int i, int j, char ch) {
        // check row
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == ch) return false;
        }
        
        // check col
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == ch) return false;
        }
        
        // check 3x3 box
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (board[row][col] == ch) return false;
            }
        }
        
        return true;
    }
}
