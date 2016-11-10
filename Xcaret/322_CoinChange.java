public class Solution {
    /**
     *  Idea -> Dynamic Programming
     *  Time complexity -> O(n*amount)
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) return amount == 0 ? 0 : -1;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Set<Integer> set = new HashSet<>();
        
        for (int coin : coins) set.add(coin);
        
        for (int i = 1; i <= amount; i++) {
            if (set.contains(i)) {
                dp[i] = 1;
            } else {
                for (int coin : set) {
                    if (coin < i && dp[i-coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                    }
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
