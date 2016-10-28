public class Solution {
    /**
     *  Idea -> We can use row-0 and col-0 to store 
     *          Attention: we need to take the first row and first col out to take into consideration seperately.
     *  Time complexity -> O(mn)
     *  Space complexity -> O(1)
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        boolean firstRow = false;
        boolean firstCol = false;
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < col; j++) matrix[i][j] = 0;
            } 
        }
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < row; i++) matrix[i][j] = 0;
            }
        }
        
        if (firstRow) for (int j = 0; j < col; j++) matrix[0][j] = 0;
        if (firstCol) for (int i = 0; i < row; i++) matrix[i][0] = 0;
    } 
     
    /**
     *  Using two sets to record the position whose value is zero,
     *  then fill out these rows and cols with zero
     *  Time complexity -> O(mn)
     *  Space compleity -> O(m+n)
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for (int r : rows) {
            for (int i = 0; i < col; i++) matrix[r][i] = 0;
        }
        for (int c : cols) {
            for (int i = 0; i < row; i++) matrix[i][c] = 0;
        }
    }
}
