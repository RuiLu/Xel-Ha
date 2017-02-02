public class Solution {
    /**
     * Idea -> Dynamica programming
     * Time complexity -> O(mn)
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        
        /* calculate all positions */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][i] = grid[i][j];
                else if (i == 0) dp[i][j] = dp[i][j-1]+grid[i][j];
                else if (j == 0) dp[i][j] = dp[i-1][j]+grid[i][j];
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
