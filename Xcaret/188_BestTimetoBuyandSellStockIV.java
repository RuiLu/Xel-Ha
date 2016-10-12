public class Solution {
    /**
     *  Idea -> 1. if the number of transactions is bigger than half number of days,
     *             do it in multiple transactions way
     *          2. otherwise, use dynamic programming, dp[k+1][len]
     *  Time complexity -> depends on the value of k -> 1. O(n); 2.O(kn)
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int len = prices.length;
        
        if (len <= k * 2) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                res += Math.max(0, prices[i] - prices[i-1]);
            }
            return res;
        }
        
        int[][] dp = new int[k+1][len];
        
        for (int i = 1; i <= k; i++) {
            int minBuyValue = dp[i-1][0] - prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j-1], minBuyValue + prices[j]);
                minBuyValue = Math.max(minBuyValue, dp[i-1][j] - prices[j]);
            }
        }
        
        return dp[k][len-1];
    }
}
