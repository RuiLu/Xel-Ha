public class Solution {
    /**
     *  Idea -> First, do binary search to the last column.
     *          Second, do binary search on the chosen row.
     * 
     *  Time complexity -> O(logm + logn).
     *  Space complexity -> O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0;
        int hi = m - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid][n-1] < target) lo = mid + 1;
            else hi = mid;
        }
        
        int row = hi;
        lo = 0;
        hi = n - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return false;
    }
}
