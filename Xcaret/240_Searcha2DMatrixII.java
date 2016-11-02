public class Solution {
    /**
     *  Idea -> Starting from up-right corner, then repeat the following two steps:
     *          first check element from right to left, second check from up to down
     *          until find target or overflow
     *  Time complexity -> O(m+n)         
     *  Space complexity -> O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int x = 0;
        int y = matrix[0].length - 1;
        
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;   
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        
        return false;
    }
}
