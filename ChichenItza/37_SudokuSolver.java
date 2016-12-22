public class Solution {
    /**
     *  Idea -> Backtracking.
     *          Before we insert a number into matrix, we should first check if this number is valid for Sudoku.
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        solver(board, 0, 0);
    }
    
    private boolean solver(char[][] board, int i, int j) {
        if (i == 9 && j == 0) return true;
        
        if (board[i][j] != '.') {
            return solver(board, j == 8 ? i+1 : i, j == 8 ? 0 : j+1);
        }
        
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, ch, i, j)) {
                board[i][j] = ch;
                if (solver(board, j == 8 ? i+1 : i, j == 8 ? 0 : j+1)) return true;
                board[i][j] = '.';
            }
        }
        
        return false;
    }
    
    private boolean isValid(char[][] board, char ch, int row, int col) {
        /* first, check row */
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == ch) return false;
        }
        
        /* second, check col */
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) return false;
        }
        
        /* third, check box */
        int newRow = row/3*3;
        int newCol = col/3*3;
        for (int i = newRow; i < newRow+3; i++) {
            for (int j = newCol; j < newCol+3; j++) {
                if (board[i][j] == ch) return false;
            }
        }
        
        return true;
    }
}
