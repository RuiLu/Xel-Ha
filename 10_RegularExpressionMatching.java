/**
 *  Thoughts are refered from -> https://discuss.leetcode.com/topic/40371/easy-dp-java-solution-with-detailed-explanation
 *  Same idea with similar solution
 */
public class Solution {

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



