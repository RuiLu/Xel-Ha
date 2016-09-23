public class Solution {
    /**
     *  Same idea as Spiral Matrix
     *  Time complexity -> O(mn)
     */
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        
        int[][] board = new int[n][n];
        int count = 1;
        int row = n;
        int col = n;
        int x = 0;
        int y = 0;
        
        while (row > 0 && col > 0) {
            if (row == 1) {
                for (int k = 0; k < col; k++) board[x][y++] = count++;
                break;
            }
            
            if (col == 1) {
                for (int k = 0; k < row; k++) board[x++][y] = count++;
            }
            
            for (int k = 0; k < col - 1; k++) board[x][y++] = count++;
            for (int k = 0; k < row - 1; k++) board[x++][y] = count++;
            for (int k = 0; k < col - 1; k++) board[x][y--] = count++;
            for (int k = 0; k < row - 1; k++) board[x--][y] = count++;
            
            row -= 2;
            col -= 2;
            x++;
            y++;
        }
        
        return board;
    }
}
