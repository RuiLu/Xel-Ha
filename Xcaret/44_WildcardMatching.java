public class Solution {
    /**
     *  Dynamic programming -> Up to bottom
     *  Basic idea is similar to Regular Expression Matching
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char pCurr = p.charAt(j - 1);
                if (pCurr != '*') {
                    dp[i][j] = i > 0 && dp[i-1][j-1] && (pCurr == '?' || pCurr == s.charAt(i - 1));
                } else {
                    /**
                     *  When pCurr == '*', there will be two situations:
                     *  1. '*' appears at the very first position of p, 
                     *      so we can set it directly to true
                     *  2. '*' appears at the latter positions of p, 
                     *      so we need to retrieve back s to see if there is any matching before.
                     */
                    boolean isMatched = false;
                    for (int k = i; k >= 0; k--) {
                        if (dp[k][j-1]) {
                            isMatched = true;
                            break;
                        }
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
        if (s == null || p == null) return false;
        
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[sLen][pLen] = true;
        
        for (int j = pLen - 1; j >= 0; j--) {
            if (p.charAt(j) != '*') break;
            dp[sLen][j] = true;
        }
        
        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = pLen - 1; j >= 0; j--) {
                if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
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
