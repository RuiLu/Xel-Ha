public class Solution {
    private int count = 0;
    
    public int totalNQueens(int n) {
        if (n <= 0) return count;
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        helper(board, 0, n);
        
        return count;
    }
    
    private void helper(char[][] board, int col, int n) {
        if (col == n) {
            count++;
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                helper(board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        for (int k = y - 1; k >= 0; k--) {
            if (board[x][k] == 'Q') return false;
        }
        
        for (int i = x + 1, j = y - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
}
