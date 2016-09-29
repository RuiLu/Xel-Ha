public class Solution {
    /**
     *  Dynamic Programming
     *  Idea -> create a 2-dimension dp matrix. dp[i][j] == true means that s1 from 0 to i and s2 from 0 to j can
     *          interleave successfully to create s3 from 0 to i+j.
     *  Time complexity -> O(mn)
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
    
        if (s3.length() != (m+n)) return false;
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) continue;
                
                int k = i + j;
                dp[i][j] = (i > 0 && s1.charAt(i-1) == s3.charAt(k-1) && dp[i-1][j]) ||
                           (j > 0 && s2.charAt(j-1) == s3.charAt(k-1) && dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
    
    /**
     *  DFS, recursion
     *  Time complexity -> (2^k)
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        if (s3.length() != (m+n)) return false;
        
        boolean[][] invalid = new boolean[m+1][n+1];
        char[] sca1 = s1.toCharArray();
        char[] sca2 = s2.toCharArray();
        char[] sca3 = s3.toCharArray();
        return isInterleave(sca1, sca2, sca3, 0, 0, 0, invalid);
    }
    
    private boolean isInterleave(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) return false;
        
        /* successfully reaching the end */
        if (k == c3.length) return true;
        
        boolean valid = (i < c1.length && c1[i] == c3[k] && isInterleave(c1, c2, c3, i+1, j, k+1, invalid)) ||
                        (j < c2.length && c2[j] == c3[k] && isInterleave(c1, c2, c3, i, j+1, k+1, invalid));
        
        if (!valid) invalid[i][j] = true;
        
        return valid;
    }
}
