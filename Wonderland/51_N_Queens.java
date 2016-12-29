public class Solution {
    /**
     *  Backtracking
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        helper(res, 0, board);
        
        return res;
    }
    
    private void helper(List<List<String>> res, int colIndex, char[][] board) {
        if (colIndex == board.length) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                tmp.add(new String(board[i]));
            }
            res.add(tmp);
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                helper(res, colIndex + 1, board);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        /* Check the col before */
        for (int i = y - 1; i >= 0; i--) 
            if (board[x][i] == 'Q') return false;
        /* Check 45-degree diagonal line before */
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 'Q') return false;
        /* Check 135-degree diagonal line before */
        for (int i = x + 1, j = y - 1; i < board.length && j >= 0; i++, j--) 
            if (board[i][j] == 'Q') return false;
            
        return true;
    }
}
