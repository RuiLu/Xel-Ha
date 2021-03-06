public class Solution {
    /**
     *  Dynamic Programming
     *  We need to consider even length and odd length of palindrome separately
     *  Time complexity -> O(n^2)   
     *  Space complexity -> O(n)
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int len = s.length();
        char[] sca = s.toCharArray();
        int[] dp = new int[len+1];
        
        // initialize dp array to possible maximum cut
        for (int i = 0; i <= len; i++) {
            dp[i] = i - 1;
        }
        
        for (int i = 0; i < len; i++) {
            // odd length
            for (int j = 0; i - j >= 0 && i + j < len && sca[i-j] == sca[i+j]; j++) {
                dp[i+j+1] = Math.min(dp[i+j+1], dp[i-j] + 1);
            }
            
            // even length 
            for (int j = 1; i - j + 1 >= 0 && i + j < len && sca[i-j+1] == sca[i+j]; j++) {
                dp[i+j+1] = Math.min(dp[i+j+1], dp[i-j+1] + 1);
            }
        }
        
        return dp[len];
    }
}
