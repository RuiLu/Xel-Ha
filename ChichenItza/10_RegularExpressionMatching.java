public class Solution {
    /**
     *  Idea -> 
     *      1. If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     *      2. If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     *      3. If p.charAt(j) == '*': 
     *          here are two sub conditions:
     *          1. if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
     *          2. if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
     *                 dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
     *              or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
     *              or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     *  Time complexity -> O(mn)
     */
    public boolean isMatch(String s, String p) {
        
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char ch = p.charAt(j-1);
                if (ch != '*') {
                    dp[i][j] = i > 0 && dp[i-1][j-1] && (ch == '.' || ch == s.charAt(i-1)); 
                } else {
                    dp[i][j] = (j > 1 && dp[i][j-2]) ||
                               (i > 0 && dp[i-1][j] && (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)));
                }
            }
        }
        
        return dp[sLen][pLen];
    }
}
