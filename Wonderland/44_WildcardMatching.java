public class Solution {
    /**
     *  1. DP -> up to bottom
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char ch = p.charAt(j-1);
                if (ch != '*') {
                    dp[i][j] = i > 0 && dp[i-1][j-1] && (ch == '?' || ch == s.charAt(i-1));
                } else {
                    // There are two situations: 
                    // 1. '*' appears at the first position of p, so dp[i][j] is true;
                    // 2. '*' appears at the other positions in p, so we need to check former result to see
                    //        if there is any matching
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
     *  2. DP -> bottom up
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[sLen][pLen] = true;
        for (int j = p.length() - 1; j >= 0; j--) {
            if (p.charAt(j) != '*') break;
            dp[sLen][j] = true;
        }
        
        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = pLen - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
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

