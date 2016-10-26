public class NumMatrix {
    /**
     *  Idea -> 2D Binary Index Tree
     */
    private int[][] BIT = null;
    private int[][] matrix = null;
    
    private void updateBIT(int i, int j, int row, int col, int val) {
        int ii = i + 1;
        
        while (ii <= row) {
            int jj = j + 1;
            
            while (jj <= col) {
                BIT[ii][jj] += val;
                jj += jj & (-jj);
            }
            
            ii += ii & (-ii);
        }
    }
    
    private int getSum(int i, int j) {
        int ii = i + 1;
        int res = 0;
        
        while (ii > 0) {
            int jj = j + 1;
            
            while (jj > 0) {
                res += BIT[ii][jj];
                jj -= jj & (-jj);
            }
            
            ii -= ii & (-ii);
        }
        
        return res;
    }
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int row = matrix.length;
        int col = matrix[0].length;
        this.matrix = matrix;
        this.BIT = new int[row+1][col+1];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                updateBIT(i, j, row, col, this.matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        int ii = row + 1;
        
        while (ii <= matrix.length) {
            int jj = col + 1;
            
            while (jj <= matrix[0].length) {
                BIT[ii][jj] += diff;
                jj += jj & (-jj);
            }
            
            ii += ii & (-ii);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a = getSum(row1 - 1, col2);
        int b = getSum(row2, col1 - 1);
        int c = getSum(row1 - 1, col1 - 1);
        int d = getSum(row2, col2);
        return d + c - a - b;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
