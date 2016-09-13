public class Solution {
    /**
     *  Same process as 54_SpiralMatrix
     *  Time complexity -> O(n^2)
     */
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][0];
        
        int[][] res = new int[n][n];
        
        int row = n;
        int col = n;
        int count = 1;
        
        int x = 0;
        int y = 0;
        
        while (row > 0 && col > 0) {
            if (row == 1) {
                for (int i = 0; i < col; i++) res[x][y++] = count++;
                break;
            }
            
            if (col == 1) {
                for (int i = 0; i < row; i++) res[x++][y] = count++;
                break;
            }
            
            for (int i = 0; i < col - 1; i++) res[x][y++] = count++;
            for (int i = 0; i < row - 1; i++) res[x++][y] = count++;
            for (int i = 0; i < col - 1; i++) res[x][y--] = count++;
            for (int i = 0; i < row - 1; i++) res[x--][y] = count++;
            
            x++;
            y++;
            
            row -= 2;
            col -= 2;
        }
        
        return res;
    }
}
