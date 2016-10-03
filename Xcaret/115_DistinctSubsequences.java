public class Solution {
    /**
     *  Dynamic Programming
     *  Reference -> https://discuss.leetcode.com/topic/9488/easy-to-understand-dp-in-java
     *  Time complexity -> O(mn)
     */
    public int numDistinct(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        
        int[][] dp = new int[tLen+1][sLen+1];
        
        // for the situation that t == "", there will always be one matching.
        for (int j = 0; j <= sLen; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i <= tLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[tLen][sLen];
    }
}
