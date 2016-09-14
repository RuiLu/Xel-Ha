public class Solution {
    /**
     *  Dynamic Programming
     *  Reference -> https://discuss.leetcode.com/topic/9488/easy-to-understand-dp-in-java/2
     *  Time complexity -> O(mn)
     */
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        int[][] dp = new int[tLen + 1][sLen + 1];
        
        for (int j = 0; j <= sLen; j++) dp[0][j] = 1;
        
        for (int i = 0; i < tLen; i++) {
            for (int j = 0; j < sLen; j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        
        return dp[tLen][sLen];
    }
}
