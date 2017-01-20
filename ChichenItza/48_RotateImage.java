public class Solution {
    /**
     * Idea -> The tricky part is how to calculate positions' transformations.
     * Time complexity -> O(n^2)
     * Space complexity -> O(1)
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) return;
        
        int n = matrix.length;
        int level = 0;
        
        while (n > 0) {
            for (int i = 0; i < n-1; i++) {
                int tmp1 = matrix[level][level+i];
                int tmp2 = matrix[level+i][n-1+level];
                int tmp3 = matrix[n-1+level][n-1-i+level];
                int tmp4 = matrix[n-1-i+level][level];
                matrix[level][level+i] = tmp4;
                matrix[level+i][n-1+level] = tmp1;
                matrix[n-1+level][n-1-i+level] = tmp2;
                matrix[n-1-i+level][level] = tmp3;
            }
            n -= 2;
            level += 1;
        }
    }
}
