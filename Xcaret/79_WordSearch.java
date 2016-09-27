public class Solution {
    /**
     *  Backtracking
     *  Let's assume word length is l,
     *  so the time complexity is O(mnl), space complexity is O(mn)
     */
    private final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.length() == 0) return false;
        
        int row = board.length;
        int col = board[0].length;
        char[] wca = word.toCharArray();
        boolean[][] visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (wca[0] == board[i][j]) {
                    if (existWord(wca, 1, i, j, board, visited)) return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean existWord(char[] word, int idx, int i, int j, char[][] board, boolean[][] visited) {
        if (idx == word.length) return true;
        
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || word[idx] != board[x][y]) {
                continue;
            }
            
            if (existWord(word, idx + 1, x, y, board, visited)) return true;
        }
        visited[i][j] = false;
        
        return false;
    }
}
