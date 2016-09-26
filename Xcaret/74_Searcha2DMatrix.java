public class Solution {
    /**
     *  Using two binary search
     *  Let's assume matrix.length == m and matrix[0].length == n,
     *  so we can get Time Complexity -> O(logm + logn)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int lo = 0;
        int hi = row - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid][col-1] == target) return true;
            else if (matrix[mid][col-1] < target) lo = mid + 1;
            else hi = mid;
        }
        
        int i = hi;
        lo = 0;
        hi = col - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (matrix[i][mid] == target) return true;
            else if (matrix[i][mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return false;
    }
}
