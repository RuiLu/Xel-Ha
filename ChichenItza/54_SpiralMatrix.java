public class Solution {
    /**
     * Idea -> The key is how to calculate the coordinates.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        
        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int k = 0; k < n; k++) res.add(matrix[i][j++]);
                break;
            }
            
            if (n == 1) {
                for (int k = 0; k < m; k++) res.add(matrix[i++][j]);
                break;
            }
            
            for (int k = 0; k < n-1; k++) res.add(matrix[i][j++]);
            for (int k = 0; k < m-1; k++) res.add(matrix[i++][j]);
            for (int k = 0; k < n-1; k++) res.add(matrix[i][j--]);
            for (int k = 0; k < m-1; k++) res.add(matrix[i--][j]);
            
            i++;
            j++;
            m -= 2;
            n -= 2;
        }
        
        return res;
    }
}
