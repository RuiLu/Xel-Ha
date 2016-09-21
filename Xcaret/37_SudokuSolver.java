public class Solution {
    /**
     *  Backtracking + determine whether the current Sudoku is valid
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        helper(board, 0, 0);
    }
    
    private boolean helper(char[][] board, int x, int y) {
        if (x == 9 && y == 0) return true;
        
        if (board[x][y] != '.') return helper(board, y == 8 ? x + 1 : x, y == 8 ? 0 : y + 1);
        
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, x, y, ch)) {
                board[x][y] = ch;
                if(helper(board, y == 8 ? x + 1 : x, y == 8 ? 0 : y + 1)) return true;
                board[x][y] = '.';
            }
        }
        
        return false;
    }
    
    private boolean isValid(char[][] board, int x, int y, char ch) {
        /* 1. check row */
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == ch) return false;
        }
        
        /* 2. check col */
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == ch) return false;
        }
        
        /* 3. check box */
        int idxX = x / 3;
        int idxY = y / 3;
        for (int i = 3 * idxX; i < (3 * idxX + 3); i++) {
            for (int j = 3 * idxY; j < (3 * idxY + 3); j++) {
                if (board[i][j] == ch) return false;
            }
        }
        
        return true;
    }

}
