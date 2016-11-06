public class Solution {
    /**
     *  Idea -> Dynamic Programming
     */
    public int numSquares(int n) {
        if (n <= 2) return n;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            int sqrt = (int)Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
            } else {
                int res = Integer.MAX_VALUE;
                for (int j = 1; j <= sqrt; j++) {
                    res = Math.min(res, dp[j*j] + dp[i-j*j]);
                }
                dp[i] = res;
            }
        }
        
        return dp[n];
    }
}
