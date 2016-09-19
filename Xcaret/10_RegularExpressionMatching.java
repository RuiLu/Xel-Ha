public class Solution {
    /**
     *  Obivously, dynamic programming
     *  Two situation -> 
     *      current character from p -> 
     *          1. not '*' ->
     *              1.1 '.' 
     *              1.2 s.c == p.c
     *          2. '*' ->
     *              2.1 '*' means nothing
     *              2.2 '*' means one or more things
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char curr = p.charAt(j-1);
                
                if (curr != '*') {
                    dp[i][j] = i > 0 && dp[i-1][j-1] && (curr == '.' || s.charAt(i-1) == curr);
                } else {
                    dp[i][j] = (j > 1 && dp[i][j-2]) ||
                               (i > 0 && dp[i-1][j] && (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)));
                }
            }
        }
        
        return dp[sLen][pLen];
    }
}
