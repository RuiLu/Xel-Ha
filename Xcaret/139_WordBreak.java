public class Solution {
    /**
     *  Dynamic Programming
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(n)
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict.size() == 0) return false;
        
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[len];
    }
    
    /**
     *  Backtracking
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict.size() == 0) return false;
        return helper(s, wordDict, 0, new HashSet<>());
    }
    
    private boolean helper(String s, Set<String> wordDict, int start, Set<Integer> failed) {
        if (start == s.length()) return true;
        
        if (failed.contains(start)) return false;
   
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                boolean res = helper(s, wordDict, i, failed);
                if (res) return true;
                else failed.add(i);
            }
        }
        
        return false;
    }
}
