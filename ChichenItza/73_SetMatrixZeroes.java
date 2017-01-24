public class Solution {
    /**
     * Idea -> Consider first row, first col, and other positions separately.
     *         Cannot set first row or first col to all 0 directly.
     * Time complexity -> O(mn)
     * Space complexity -> O(1)
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRow = false;
        boolean firstCol = false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /* if 0's are on row-0 or col-0, only set indicators to true */
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        /* take row-0 and col-0 out, first set other qualified positions to 0 */
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) matrix[i][j] = 0;
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) matrix[i][j] = 0;
            }
        }
        
        /* finally, set row-0 or col-0 to 0 if they are qualified. */
        if (firstRow) for (int j = 0; j < n; j++) matrix[0][j] = 0;
        if (firstCol) for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
}
