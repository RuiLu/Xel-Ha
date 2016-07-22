public class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        if (n <= 1) return 0;
        
        // cannot reach to k transations
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                maxProfit += Math.max(0, prices[i] - prices[i-1]);
            }
            return maxProfit;
        }
        
        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int currMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], currMax + prices[j]);
                currMax = Math.max(currMax, dp[i-1][j] - prices[j]);
            }
        }
        
        return dp[k][n-1];
        
        
        /* memory limit error */
        // if (k == 0) return 0;
        
        // int[] buys = new int[k];
        // int[] sells = new int[k];
        
        // for (int i = 0; i < k; i++) {
        //     buys[i] = Integer.MIN_VALUE;
        // }
        
        // for (int price : prices) {
        //     buys[0] = Math.max(buys[0], -price);
        //     sells[0] = Math.max(sells[0], buys[0] + price);
        //     for (int i = 1; i < k; i++) {
        //         buys[i] = Math.max(buys[i], sells[i - 1] - price);
        //         sells[i] = Math.max(sells[i], buys[i] + price);
        //     }
        // }
        
        // return sells[k - 1];
    }
}
