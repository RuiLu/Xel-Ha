public class Solution {
    /**
     *  Idea -> Dynamic programming.
     *          Build a 2D dp array dp[len1+1][len2+1], 
     *          dp[i][j] indicates the shortest edit distance between word1[0,i) and word2[0,j)
     *          Now we compare ith position of word1 and jth position of word2.
     *          (All operations are targeted on word1)
     *          1. Replace - dp[i][j] = dp[i-1][j-1]+1
     *          2. add     - dp[i][j] = dp[i][j-1]+1
     *          3. delete  - dp[i][j] = dp[i-1][j]+1
     * 
     *  Time complexity -> O(mn)
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        
        // Initialization, n steps are needed to form a n-length string from an empty string
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int j = 0; j <= len2; j++) dp[0][j] = j;
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 1. replace - dp[i][j] = dp[i-1][j-1]+1
                    // 2. insert  - dp[i][j] = dp[i][j-1]+1
                    // 3. delete  - dp[i][j] = dp[i-1][j]+1
                    // find the minimum number among above three operations
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
                }
            }           
        }
        
        return dp[len1][len2];
    }
}
