public class Solution {
    /**
     *  Idea -> No need to detect whether the board is valid
     *          Count directly, if there is ship before the line, vertically or horizontally, continue
     *  Time complexity -> O(mn)
     *  Space complexity -> O(1)
     */ 
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if (j > 0 && board[i][j] == board[i][j-1]) continue;
                    if (i > 0 && board[i][j] == board[i-1][j]) continue;
                    count++;
                }
            }
        }
        return count;
    }    
    
    /**
     *  Idea -> First to detect where the board is valid or not
     *          Then count
     */
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        
        int res = 0;
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            boolean horizontal = false;
            boolean vertical = false;
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    if (j > 0 && board[i][j] == board[i][j-1]) {
                        horizontal = true;
                        if (vertical) return 0;
                    }
                    if ((i > 0 && board[i-1][j] == 'X') || (i < row - 1 && board[i+1][j] == 'X')) {
                        vertical = true;
                        if (horizontal) return 0;
                    }
                } else {
                    horizontal = false;
                    vertical = false;
                }
            }
        }
        
        boolean[][] visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    res++;
                    dfs(board, i, j, visited);
                }
            }
        }
        
        return res;
    }

    // private void dfs(char[][] board, int i, int j, boolean[][] visited) {
    //     if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != 'X') return;
        
    //     visited[i][j] = true;
    //     dfs(board, i - 1, j, visited);
    //     dfs(board, i + 1, j, visited);
    //     dfs(board, i, j - 1, visited);
    //     dfs(board, i, j + 1, visited);
    // }
}
