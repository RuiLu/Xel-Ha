public class Solution {
    /**
     *  Dynamic Programming
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(n)
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) return false;
        
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int left = 0; left < i; left++) {
                if (dp[left] && wordDict.contains(s.substring(left, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    // }
    
    /**
     *  Backtracking
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) return false;
        Set<Integer> failed = new HashSet<>();
        return helper(s, wordDict, 0, failed);
    }
    
    private boolean helper(String s, Set<String> wordDict, int start, Set<Integer> failed) {
        if (start == s.length()) {
            return true;
        }
        
        if (failed.contains(start)) {
            return false;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                if (helper(s, wordDict, i, failed)) {
                    return true;
                } else {
                    failed.add(start);
                }
            }
        }
        
        return false;
    }
}
