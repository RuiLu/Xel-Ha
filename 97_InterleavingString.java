// 1. DP
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m = s1.length(), n = s2.length();
        if ((m + n) != s3.length()) return false;
        boolean[][] dp = new boolean[m+1][n+1];
        
        dp[0][0] = true;
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j && i == 0) continue;
                int k = i + j;
                dp[i][j] = (i >= 1 && dp[i-1][j] && s1.charAt(i-1) == s3.charAt(k-1)) ||
                          (j >= 1 && dp[i][j-1] && s2.charAt(j-1) == s3.charAt(k-1));
            }
        }
        
        return dp[m][n];
        
//     }
// }

// 2. DFS
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if ((m + n) != s3.length()) return false;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m+1][n+1]);
    }
    
    private boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) return false;
        if (k == c3.length) return true;
        boolean valid = (i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i+1, j, k+1, invalid)) ||
                        (j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j+1, k+1, invalid));
        if (!valid) invalid[i][j] = true;
        return valid;
    }
}
