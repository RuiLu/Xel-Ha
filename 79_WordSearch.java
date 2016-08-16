/**
 *  Only one word, so there is no need to build a trie. The point is to do backtracking.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs_exist(board, array, i, j, 0)) return true;   
            }
        }
        
        return false;
    }
    
    private boolean dfs_exist(char[][] board, char[] array, int i, int j, int index) {
        if (index == array.length) return true;
        
        char ch = array[index];
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || ch != board[i][j]) return false;
        
        board[i][j] = '#';      // '#' indicates that this position has been visited
        
        boolean res = dfs_exist(board, array, i - 1, j, index + 1) ||
                      dfs_exist(board, array, i + 1, j, index + 1) ||
                      dfs_exist(board, array, i, j - 1, index + 1) ||
                      dfs_exist(board, array, i, j + 1, index + 1);
        
        board[i][j] = ch;       // backtracking
        
        return res;
    }
   
}

