public class Solution {
    /**
     *  Dynamic Programming
     *  Time complexity -> O(mn)
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        
        /* initialize the distance array */
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    /* no need for any operation */
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    /* 1. insert->dp[i][j-1]; 2. delete->dp[i-1][j]; 3. replace->dp[i-1][j-1] */
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        
        return dp[len1][len2];
    }
}
