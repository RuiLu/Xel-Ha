public class Solution {
    /**
     *  Idea -> Dynamic programming
     *  Time complexity -> O(n*amount)
     *  Space complexity -> O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        
        int[] dp = new int[amount+1];
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }
        
        for (int i = 1; i <= amount; i++) {
            if (dp[i] == 1) continue;
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin < i && dp[i-coin] != 0) min = Math.min(min, dp[i-coin] + 1);
            }
            dp[i] = min == Integer.MAX_VALUE ? 0 : min;
        }
        
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
