public class Solution {
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
        
        for (int i = 0; i< row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for (int i : rows) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;
            }
        }
        
        for (int j : cols) {
            for (int i = 0; i < row; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
