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
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cache[i][j] != 0) maxLen = Math.max(maxLen, cache[i][j]);
                else maxLen = Math.max(maxLen, findLongest(matrix, i, j, m, n, cache));
            }
        }
        
        return maxLen;
    }
    
    private int findLongest(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        // cache[i][j] != 0 means we have visited this position before.
        if (cache[i][j] != 0) return cache[i][j];
        
        int max = 1;
        for (int[] dir : dirs) {
            int x = i+dir[0];
            int y = j+dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n || matrix[i][j] >= matrix[x][y]) continue;
            int len = 1+findLongest(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        
        // Assign the longest distance for every visited position.
        cache[i][j] = max;
        return max;
    }
}
