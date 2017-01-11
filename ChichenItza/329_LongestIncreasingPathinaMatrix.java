public class Solution {
    /**
     *  Idea -> DFS + backtracking
     *  Time complexity -> O(mn), because we memorized the longest distance for each visited position,
     *                            we don't do calculate again for visited position.
     *                            So we actually access each position in matrix only once.
     *  Space complexity -> O(mn)
     */
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
     
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int maxLen = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] cache = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (cache[i][j] != 0) maxLen = Math.max(maxLen, cache[i][j]);
                else maxLen = Math.max(maxLen, helper(matrix, i, j, row, col, cache));
            }
        }
        
        return maxLen;
    }
    
    private int helper(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        // have already visited this position
        if (cache[i][j] != 0) return cache[i][j];
        
        // the max path length starting from this position
        int max = 1;
        
        for (int[] dir : dirs) {
            int x = i+dir[0];
            int y = j+dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = helper(matrix, x, y, m, n, cache)+1;
            max = Math.max(max, len);
        }
        
        // assign the longest distance to this visited position.
        cache[i][j] = max;
        return max;
    }
}
