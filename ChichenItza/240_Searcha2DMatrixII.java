public class Solution {
    /**
     * Idea -> Key is to start from up-right corner.
     *         Search row from right to left until find an element which is less than or equal to target.
     *         Then search col from up to bottom until find an element which is bigger than or equal to target.
     * Time complexity -> O(m+n)
     * Space complexity -> O(1)
     */ 
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        /* start searching from up-right corner */
        int i = 0;
        int j = n-1;
        
        while (i < m && j >= 0) {
            /* first search from right to left until element is less than or equal to target  */
            while (i < m && j >= 0 && matrix[i][j] > target) j--;
            /* then search from up to bottom until elment is bigger than or equal to target */
            while (i < m && j >= 0 && matrix[i][j] < target) i++;
            if (i < m && j >= 0 && matrix[i][j] == target) return true;
        }
        
        return false;
    }
}
