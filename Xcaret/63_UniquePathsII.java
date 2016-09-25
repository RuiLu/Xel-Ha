public class Solution {
    /**
     *  Dynamic Programming
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || obstacleGrid[i][j] == 1) continue;
                else if (i == 0) {
                    if (obstacleGrid[i][j-1] != '1') {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = 0;
                    }
                } else if (j == 0) {
                    if (obstacleGrid[i-1][j] != '1') {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    dp[i][j] = (obstacleGrid[i-1][j] != '1' ? dp[i-1][j] : 0) +
                               (obstacleGrid[i][j-1] != '1' ? dp[i][j-1] : 0);
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
