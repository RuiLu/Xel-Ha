/**
 *  Using dynamic programming
 */
public class Solution {
    public int numSquares(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int sqrt = (int)Math.sqrt(i);
            if (sqrt * sqrt == i) {
                dp[i] = 1;
            } else {
                int res = Integer.MAX_VALUE;
                for (int j = sqrt; j >= 1; j--) {
                    res = Math.min(res, dp[j * j] + dp[i - j * j]);
                }
                dp[i] = res;
            }
        }
        
        return dp[n];
    }
}
