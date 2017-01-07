public class NumMatrix {
    /**
     *  Solution One -> Suitable for immutable matrix.
     *  Idea -> Create a 2D area array, each position store the sum from (0,0)~(i,j).
     *          Be careful with the corner condition.
     *  Time complexity -> O(mn) for constructor. O(1) for sumRegion.
     */
    private int[][] area; 
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int row = matrix.length;
        int col = matrix[0].length;
        area = new int[row+1][col+1];
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                area[i][j] = area[i-1][j]+area[i][j-1]-area[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum1 = area[row1][col1];
        int sum2 = area[row1][col2+1];
        int sum3 = area[row2+1][col1];
        int sum4 = area[row2+1][col2+1];
        return sum4+sum1-sum2-sum3;
    }
    
    /**
     *  Solution Two -> Binary Index Tree
     *  Time complexity -> O(mnlogmlogn) for constructor. O(logmlogn) for sumRegion.
     */
    private int[][] bit;
    
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
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                updateBIT(i, j, matrix[i][j]);
            }
        }
    }
    
    private int getSum(int i, int j) {
        int val = 0;
        int indexI = i+1;
        while (indexI > 0) {
            int indexJ = j+1;
            while(indexJ > 0) {
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
// numMatrix.sumRegion(1, 2, 3, 4);
