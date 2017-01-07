public class Solution {
    /**
     *  Time complexity -> depends on the value of k -> 1. O(n); 2.O(kn)
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) return 0;
        
        int len = prices.length;
        
        if (k >= len/2) {
            /* k >= len(prices)/2, can do as many transactions as possible */
            int profit = 0;
            for (int i = 1; i < len; i++) {
                profit += Math.max(0, prices[i]-prices[i-1]);
            }
            return profit;
        } else {
            /* k < len(prices)/2, can at most k transactions */
            int[][] dp = new int[k+1][len];
            for (int i = 1; i <= k; i++) {
                int minBuyValue = -prices[0];
                for (int j = 1; j < len; j++) {
                    /* current maxProfit is chosen between 1. do nothing today and 2. sell stock today. */
                    dp[i][j] = Math.max(dp[i][j-1], minBuyValue+prices[j]);
                    /* current mBY is chosen between 1. previous mBY and 2. maxProfit made last transaction - curr prices */
                    minBuyValue = Math.max(minBuyValue, dp[i-1][j]-prices[j]);
                }
            }
            return dp[k][len-1];
        }
    }
}
