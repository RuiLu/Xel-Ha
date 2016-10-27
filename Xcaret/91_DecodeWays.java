public class Solution {
    /**
     *  Dynamic Programming
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    private boolean isValid(String s) {
        if (s.length() == 1) {
            if (s.equals("0")) return false;
            return true;
        }
        
        return Integer.parseInt(s) >= 10 && Integer.parseInt(s) <= 26;
    } 
     
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        
        for (int i = 1; i <= len; i++) {
            if (isValid(s.substring(i - 1, i))) dp[i] += dp[i-1];
            if (i > 1 && isValid(s.substring(i - 2, i))) dp[i] += dp[i-2];
        }
        
        return dp[len];
    }
    
}
