public class Solution {
    /**
     *  Idea -> 00(0) -> dead to dead
     *          01(1) -> live to dead
     *          10(2) -> dead to live
     *          11(3) -> live to live
     *  Time complexity -> O(mn)
     *  Space complexity -> O(1)
     */
    private static int[][] dirs = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};
     
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int row = board.length;
        int col = board[0].length;
        
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = 0;
                int isLive = board[i][j] & 1;
                
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    
                    if (x >= 0 && y >= 0 && x < row && y < col) {
                        lives += board[x][y] & 1;
                    }
                }
                
                if ((lives >= 2 && lives <= 3 && isLive == 1) ) {
                    board[i][j] = 3;
                } else if (lives == 3 && isLive == 0) {
                    board[i][j] = 2;  
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
