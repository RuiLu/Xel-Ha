public class Solution {
    /**
     *  Time complexity -> depends on the value of k -> 1. O(n); 2.O(kn)
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k < 1) return 0;
        
        int len = prices.length;
        
        // If the number of transactions are bigger or equal to half the number of days, 
        // then do it in multiple transactions way.
        // Otherwise, use Dynamic programming.
        if (k*2 >= len) {
            int res = 0;
            for (int i = 1; i < len; i++) {
                res += Math.max(0, prices[i]-prices[i-1]);
            }
            return res;
        } else {
            int[][] dp = new int[k+1][len];
            for (int i = 1; i <= k; i++) {
                int minBuyValue = -prices[0];
                for (int j = 1; j < len; j++) {
                    dp[i][j] = Math.max(dp[i][j-1], minBuyValue+prices[j]);
                    minBuyValue = Math.max(minBuyValue, dp[i-1][j]-prices[j]);
                }
            }
            return dp[k][len-1];
        }
    }
}
