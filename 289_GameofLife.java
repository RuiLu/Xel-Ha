/**
 *  Use 2-bit to represent the change of state: 1 -> live; 2 -> dead.
 *  For example: 1. from live to live: 01(1) -> 11(3)
 *               2. from live to dead: 01(1) -> 01(1) -> no change
 *               3. from dead to live: 00(0) -> 10(2)
 *               4. from dead to dead: 00(0) -> 00(0) -> no change
 *  So we only need to consider the first and the third situations.
 * 
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        int row = board.length;
        int col = board[0].length;
        
        // Step 1 -> determine next state for each cell
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = getLives(board, i, j, row, col);
                
                // first situation
                if (lives >= 2 && lives <= 3 && board[i][j] == 1) {
                    board[i][j] = 3;
                }
                
                // third situation
                if (lives == 3 && board[i][j] == 0) {
                    board[i][j] = 2;
                }
            }
        }
        
        // Step -> get 2nd bit, which represents the next state
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    private int getLives(int[][] board, int i, int j, int row, int col) {
        int lives = 0;
        
        for (int x = Math.max(0, i - 1); x <= Math.min(row - 1, i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(col - 1, j + 1); y++) {
                lives += board[x][y] & 1; // we only care the current state
            }
        }
        
        lives -= board[i][j] & 1; // take the self value out
        
        return lives;
    }
}
