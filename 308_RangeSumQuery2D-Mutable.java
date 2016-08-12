/**
 *  Binary Index Tree -> Time complexity: 0(log(m) * log(n))
 */
public class NumMatrix {

    private int[][] bit;
    private int[][] num;
    private int row;
    private int col;

    public NumMatrix(int[][] matrix) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
       
       row = matrix.length;
       col = matrix[0].length;
       bit = new int[row + 1][col + 1];
       num = new int[row][col];
       
       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               update(i, j, matrix[i][j]);
           }
       }
    }

    public void update(int i, int j, int val) {
        if (row == 0 || col == 0) return;
        
        int diff = val - num[i][j];
        num[i][j] = val;
        
        int indexI = i + 1;
        while (indexI <= row) {
            int indexJ = j + 1;
            while (indexJ <= col) {
                bit[indexI][indexJ] += diff;
                indexJ += indexJ & (-indexJ);
            }
            indexI += indexI & (-indexI);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) + getSum(row1 - 1, col1 - 1) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1);
    }
    
    private int getSum(int i, int j) {
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
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
