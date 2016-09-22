public class Solution {
    /**
     *  Backtracking
     *  Time complexity -> O(n^3)
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        helper(res, board, 0, n);
        
        return res;
    }
    
    private void  helper(List<List<String>> res, char[][] board, int colIdx, int n) {
        if (colIdx == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] row : board) {
                tmp.add(String.valueOf(row));
            }
            res.add(tmp);
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (isValid(board, row, colIdx)) {
                board[row][colIdx] = 'Q';
                helper(res, board, colIdx + 1, n);
                board[row][colIdx] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        /* check previous characters in the same row */
        for (int k = y - 1; k >= 0; k--) {
            if (board[x][k] == 'Q') return false;
        }
        
        /* check previous characters from 45-degree diagonal line */
        for (int i = x + 1, j = y - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        /* check previous charachters from 135-degree diagonal line */
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
}
