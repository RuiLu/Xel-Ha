public class NumMatrix {

    public int[][] bit;
    public int row;
    public int col;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        row = matrix.length;
        col = matrix[0].length;
        bit = new int[row+1][col+1];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                updateBIT(i, j, matrix[i][j]);
            }
        }
    }

    public void updateBIT(int i, int j, int val) {
        if (row == 0 || col == 0) return;
        
        int indexI = i + 1;
        while (indexI <= row) {
            int indexJ = j + 1;
            while (indexJ <= col) {
                bit[indexI][indexJ] += val;
                indexJ += indexJ & (-indexJ);
            }
            indexI += indexI & (-indexI);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) + getSum(row1-1, col1-1) - getSum(row2, col1-1) - getSum(row1-1, col2);
    }
    
    public int getSum(int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col) return 0;
        
        int sum = 0;
        
        int indexI = i + 1;
        while (indexI > 0) {
            int indexJ = j + 1;
            while (indexJ > 0) {
                sum += bit[indexI][indexJ];
                indexJ -= indexJ & (-indexJ);
            }
            indexI -= indexI & (-indexI);
        }
        
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
