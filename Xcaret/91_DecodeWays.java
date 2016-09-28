public class Solution {
    /**
     *  Dynamic Programming
     *  Time complexity -> O(n)
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int len = s.length();
        int[] dp = new int[len+1];
        
        dp[0] = 1;
        if (isValid(s.substring(0, 1))) dp[1] = 1;
        else dp[1] = 0;
        
        for (int i = 2; i <= len; i++) {
            if (isValid(s.substring(i-1, i))) dp[i] += dp[i-1];
            if (isValid(s.substring(i-2, i))) dp[i] += dp[i-2];
        }
        
        return dp[len];
    }
    
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        int value = Integer.parseInt(s);
        return value >= 1 && value <= 26;
    }
}
