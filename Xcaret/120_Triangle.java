public class Solution {
    /**
     *  Dynamic Programming
     *  Time complexity -> O(m!), where m is the size of triangle
     *  Space complexity -> O(m^2)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        
        int[][] dp = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                int currVal = triangle.get(i).get(j);
                if (i == 0 && j == 0) {
                    dp[i][j] = currVal;
                } else if (j == 0) {
                    dp[i][j] += dp[i-1][j] + currVal;
                } else if (j == i) {
                    dp[i][j] += dp[i-1][j-1] + currVal;
                } else {
                    dp[i][j] += Math.min(dp[i-1][j-1], dp[i-1][j]) + currVal;
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dp[m-1][i] < min) min = dp[m-1][i];
        }
        
        return min;
    }
}
