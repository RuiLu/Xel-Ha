public class Solution {
    /**
     *  Idea -> Backtracking
     *  Time complexity -> O(mnl)
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtracking(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean backtracking(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;
        
        char ch = word.charAt(idx);
        
        // If current position is beyond the given matrix, or this position has been visited,
        // or the value of current position doesn't equal to the corresponding value on word.
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#'|| ch != board[i][j] ) {
            return false;
        }
        
        // Do backtracking, '#' means this position has been visited.
        board[i][j] = '#';
        boolean res = backtracking(board, word, i-1, j, idx+1) ||
                      backtracking(board, word, i, j-1, idx+1) ||
                      backtracking(board, word, i+1, j, idx+1) ||
                      backtracking(board, word, i, j+1, idx+1);
        board[i][j] = ch;
        
        return res;
    }
}
