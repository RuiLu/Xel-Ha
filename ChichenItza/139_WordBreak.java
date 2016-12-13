public class Solution {
    /**
     *  Idea -> Dynamic Programming
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(n)
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                String sub = s.substring(j, i);
                if (wordDict.contains(sub)) {
                    dp[i] = dp[j];
                    if (dp[i]) break;
                }
            }
        }
        
        return dp[dp.length-1];
    }
    
    /**
     *  Idea -> DFS + Backtracking
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        Set<String> failed = new HashSet<String>();
        return wordBreakHelper(s, wordDict, failed);
    }
    
    private boolean wordBreakHelper(String s, Set<String> wordDict, Set<String> failed) {
        if (s.equals("")) return true;
        if (failed.contains(s)) return false;
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (wordBreakHelper(s.substring(word.length()), wordDict, failed)) return true;
            }
        }
        
        failed.add(s);
        return false;
    }
}
