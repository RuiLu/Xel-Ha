public class Solution {
    /**
     *  DP -> O(n^2)
     */
    public int integerBreak(int n) {
        if (n < 2) return 0;
        
        int[] dp = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]), dp[i]);
            }
        }
        
        return dp[n];
    }
    
    /**
     *  Divide and Conquer -> Time complexity might be O(n!)
     */
    private Map<Integer, Integer> map = new HashMap<>();
    
    public int integerBreak(int n) {
        if (n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(Math.max(res, i * (n - i)), i * integerBreak(n - i));
        }
        map.put(n, res);
        return res;
    }
}
