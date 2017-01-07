public class NumMatrix {
    /**
     *  Idea -> Binary Index Tree
     */
    private int[][] bit;
    private int[][] matrix;

    private void updateBIT(int i, int j, int val) {
        int indexI = i+1;
        while (indexI < bit.length) {
            int indexJ = j+1;
            while (indexJ < bit[0].length) {
                bit[indexI][indexJ] += val;
                indexJ += indexJ & (-indexJ);
            }
            indexI += indexI & (-indexI);
        }
    }

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int row = matrix.length;
        int col = matrix[0].length;
        bit = new int[row+1][col+1];
        this.matrix = matrix;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                updateBIT(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        updateBIT(row, col, diff);
    }

    private int getSum(int i, int j) {
        int val = 0;
        int indexI = i+1;
        while (indexI > 0) {
            int indexJ = j+1;
            while (indexJ > 0) {
                val += bit[indexI][indexJ];
                indexJ -= indexJ & (-indexJ);
            }
            indexI -= indexI & (-indexI);
        }
        return val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum1 = getSum(row1-1, col1-1);
        int sum2 = getSum(row1-1, col2);
        int sum3 = getSum(row2, col1-1);
        int sum4 = getSum(row2, col2);
        return sum4+sum1-sum2-sum3;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
