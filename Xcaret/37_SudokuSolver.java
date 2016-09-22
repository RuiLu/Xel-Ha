public class Solution {
    /**
     *  Backtracking + determine whether the current Sudoku is valid
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        helper(board, 0, 0);
    }
    
    private boolean helper(char[][] board, int i, int j) {
        if (i == 9 && j == 0) return true;
        
        if (board[i][j] != '.') return helper(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);
        
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, i, j, ch)) {
                board[i][j] = ch;
                if (helper(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1)) return true;
                board[i][j] = '.';
            }
        }
        
        return false;
    }
    
    private boolean isValid(char[][] board, int i, int j, char ch) {
        /* check row */
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == ch) return false;
        }
        
        /* check col */
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == ch) return false;
        }
        
        /* check box */
        for (int x = i / 3 * 3; x < i / 3 * 3 + 3; x++) {
            for (int y = j / 3 * 3 ; y < j / 3 * 3 + 3; y++) {
                if (board[x][y] == ch) return false;
            }
        }
        
        return true;
    }
}
