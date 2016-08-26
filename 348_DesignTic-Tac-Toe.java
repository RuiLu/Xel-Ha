/**
 *  Tic-Tac-Toe -> 就是连子游戏...
 * 
 *  Per move(), time complexity is O(1)
 *  But need more space, space complexity is O(4n+2*2) = O(n),
 *  
 *  So, since time complexity is O(1), we need to try to improve space complexity, now I find a way,
 *  save space to O(2*N+2).
 */
public class TicTacToe {

    // private int[][] board; // player1 -> 1; player2 -> 2
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        // board = new int[n][n];
        size = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int addTo = player == 1 ? 1 : -1;
        
        rows[row] += addTo;
        cols[col] += addTo;
        
        if (row == col) diagonal += addTo;
        if (row + col == size - 1) antiDiagonal += addTo;
        
        if (Math.abs(rows[row]) == size || 
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size || 
            Math.abs(antiDiagonal) == size) 
        {
                return player;
        }
        
        return 0;
    }
    
}


// public class TicTacToe {

//     // private int[][] board; // player1 -> 1; player2 -> 2
//     private int[] oneRows;
//     private int[] oneCols;
//     private int[] twoRows;
//     private int[] twoCols;
//     private int[] oneDiag;
//     private int[] twoDiag;
//     private int size;

//     /** Initialize your data structure here. */
//     public TicTacToe(int n) {
//         // board = new int[n][n];
//         size = n;
//         oneRows = new int[n];
//         oneCols = new int[n];
//         oneDiag = new int[2];
//         twoRows = new int[n];
//         twoCols = new int[n];
//         twoDiag = new int[2];
//     }
    
//     /** Player {player} makes a move at ({row}, {col}).
//         @param row The row of the board.
//         @param col The column of the board.
//         @param player The player, can be either 1 or 2.
//         @return The current winning condition, can be either:
//                 0: No one wins.
//                 1: Player 1 wins.
//                 2: Player 2 wins. */
//     public int move(int row, int col, int player) {
//         if (player == 1) {
//             oneRows[row]++;
//             oneCols[col]++;
//             if (row == col) {
//                 oneDiag[0]++;
//                 if (row == size / 2) oneDiag[1]++;
//             }
//             else if (row + col == size - 1) oneDiag[1]++;
//             if (oneRows[row] == size || oneCols[col] == size ||
//                 oneDiag[0] == size || oneDiag[1] == size) return player;
//         } else if (player == 2) {
//             twoRows[row]++;
//             twoCols[col]++;
//             if (row == col) {
//                 twoDiag[0]++;
//                 if (row == size / 2) twoDiag[1]++;
//             }
//             else if (row + col == size - 1) twoDiag[1]++;
//             if (twoRows[row] == size || twoCols[col] == size || 
//                 twoDiag[0] == size || twoDiag[1] == size) return player;
//         }
        
//         return 0;
//     }
    
// }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
