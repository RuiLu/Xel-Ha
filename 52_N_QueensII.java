public class Solution {
    /**
     *  Use same idea as N-Queen
     */
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        
        char[][] board = new char[n][n];
        int[] res = new int[1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        helper(board, res, 0);
        
        return res[0];
    }
    
    private void helper(char[][] board, int[] res, int colIdx) {
        if (colIdx == board.length) {
            res[0]++;
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, colIdx)) {
                board[i][colIdx] = 'Q';
                helper(board, res, colIdx + 1);
                board[i][colIdx] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        /* check columns before */
        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == 'Q') return false;
        }
        
        /* check 45-degree diagonal line before */
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        /* check 135-degree diagonal line before */
        for (int i = x + 1, j = y - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
}
