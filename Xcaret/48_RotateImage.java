public class Solution {
    /**
     *  Time complexity -> O(n^2)
     *  Because we access each point once
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) return;
        
        int len = matrix.length;
        
        helper(matrix, 0, 0, len);
    }
    
    private void helper(int[][] matrix, int x, int y, int len) {
        if (len < 0) return;
        
        int limit = len - 1;
        
        for (int k = 0; k < limit; k++) {
            int tmp0 = matrix[x][y+k];
            int tmp1 = matrix[x+k][y+limit];
            int tmp2 = matrix[x+limit][y+limit-k];
            int tmp3 = matrix[x+limit-k][y];
            
            matrix[x][y+k] = tmp3;
            matrix[x+k][y+limit] = tmp0;
            matrix[x+limit][y+limit-k] = tmp1;
            matrix[x+limit-k][y] = tmp2;
        }
        
        helper(matrix, x+1, y+1, len-2);
    }
}
