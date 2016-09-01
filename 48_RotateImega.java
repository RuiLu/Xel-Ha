public class Solution {
    /**
     *  In-place
     */
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) return;
        
        int len = matrix.length;
        helper(matrix, 0, 0, len);
    } 
    
    private void helper(int[][] matrix, int i, int j, int len) {
        if (len < 0) return;
        
        int limit = len - 1;
        
        for (int k = 0; k < limit; k++) {
            int tmp0 = matrix[i][j + k];
            int tmp1 = matrix[j + k][i + limit];
            int tmp2 = matrix[i + limit][j + limit - k];
            int tmp3 = matrix[j + limit - k][i];
            matrix[i][j + k] = tmp3;
            matrix[j + k][i + limit] = tmp0;
            matrix[i + limit][j + limit - k] = tmp1;
            matrix[j + limit - k][i] = tmp2;
        }
        
        helper(matrix, i + 1, j + 1, len - 2);
    }
    
    /**
     *  Not in-place
     */
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) return;
        
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) tmp[i][j] = matrix[i][j];
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - i - 1] = tmp[i][j]; 
            }
        }
    }
}
