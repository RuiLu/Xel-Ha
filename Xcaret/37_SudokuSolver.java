public class Solution {
    /**
     *  Backtracking + determine whether the current Sudoku is valid
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        solver(board, 0, 0);
    }
    
    private boolean solver(char[][] board, int i, int j) {
        if (i == 9 && j == 0) return true;
        
        if (board[i][j] != '.') return solver(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);
        
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, ch, i, j)) {
                board[i][j] = ch;
                if (solver(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1)) return true;
                board[i][j] = '.';
            }
        }
        
        return false;
    }
    
    private boolean isValid(char[][] board, char ch, int i, int j) {
        /* check row */
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == ch) return false;
        }
        
        /* check col */
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == ch) return false;
        }
        
        /* check box */
        for (int x = (i/3*3); x < (i/3*3+3); x++) {
            for (int y = (j/3*3); y < (j/3*3+3); y++) {
                if (board[x][y] == ch) return false;
            }
        }
        
        return true;
    }
}
