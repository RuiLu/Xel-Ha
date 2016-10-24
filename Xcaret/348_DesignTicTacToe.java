public class TicTacToe {
    /**
     *  Idea -> Using two arrays to store the number of chesses of each row and col,
     *          using two variables to store the number of chesses on diagonal and antidiagonal
     *          When playing 'X', plus 1; when playing 'O', plus -1
     *          End game when any absolute value of above arrays/variables reaches 3.
     *          
     *  Time complexity -> O(1)
     *  Space complexity -> O(n)
     */
    private int[] rows = null;
    private int[] cols = null;
    private int diagonal = 0;
    private int antidiagonal = 0;
    private int size = 0;
    
     
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antidiagonal = 0;
        size = n;
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
        rows[row] += player == 1 ? 1 : -1;
        if (Math.abs(rows[row]) == size) return rows[row] == size ? 1 : 2;
        
        cols[col] += player == 1 ? 1 : -1;
        if (Math.abs(cols[col]) == size) return cols[col] == size ? 1 : 2;
        
        if (row == col) {
            diagonal += player == 1 ? 1 : -1;
            if (Math.abs(diagonal) == size) return diagonal == size ? 1 : 2;
        }
        
        if ((row + col) == (size - 1)) {
            antidiagonal += player == 1 ? 1 : -1;
            if (Math.abs(antidiagonal) == size) return antidiagonal == size ? 1 : 2;
        }
        
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
