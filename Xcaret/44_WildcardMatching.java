public class Solution {
    /**
     *  Dynamic programming -> Up to bottom
     *  Basic idea is similar to Regular Expression Matching
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
                    dp[i][j] = i > 0 && dp[i-1][j-1] && (curr == '?' || curr == s.charAt(i-1));
                } else {
                    /**
                     *  1. '*' is at the first position of pattern
                     *  2. '*' is at the any position of pattern, except for the first position
                     */
                    int k = i;
                    boolean isMatched = false;
                    while (k >= 0) {
                        if (dp[k][j-1]) {
                            isMatched = true;
                            break;
                        }
                        k--;
                    }
                    
                    dp[i][j] = j == 1 || isMatched;
                }
            }
        }
        
        return dp[sLen][pLen];
    }
    
    /**
     *  Bottom up
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[sLen][pLen] = true;
        
        for (int k = pLen - 1; k >= 0; k--) {
            if (p.charAt(k) != '*') break;
            dp[sLen][k] = true;
        }
        
        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = pLen - 1; j >= 0; j--) {
                if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[0][0];
    }
}
