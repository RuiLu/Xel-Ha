public class Solution {
    /**
     *  Idea -> Starts from up-right corner, then repeats the following three steps:
     *          1. scan from right to left until value <= target;
     *          2. scan from up to down until value >= target.
     *          3. stop when find the target or overflow.
     *  Time complexity -> O(m+n)
     *  Space complexity -> O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int x = 0;
        int y = matrix[0].length - 1;
        
        while (x < matrix.length && y >= 0) {
            while (x < matrix.length && y >= 0 && matrix[x][y] > target) y--;
            while (x < matrix.length && y >= 0 && matrix[x][y] < target) x++;
            if (x < matrix.length && y >= 0 && matrix[x][y] == target) return true;
        }
        
        return false;
    }
}
