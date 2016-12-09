public class Solution {
    /**
     *  Idea -> Dynamic Programming: dp[i] = dp[j] && wordDict.contains(s.substring(i, j)), where j is from [0,i)
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(n)
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) return false;
        
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i))) {
                    dp[i] = dp[j];
                    if (dp[i]) break;
                }
            }
        }
        
        return dp[len];
    }
    
    /**
     *  Idea -> DFS + memorization
     */
    private boolean dfsHelper(String s, Set<String> wordDict, Set<String> failed) {
        if (s.equals("")) return true;
        if (failed.contains(s)) return false;
        
        for (int i = 1; i <= s.length(); i++) {
            String curr = s.substring(0, i);
            if (wordDict.contains(curr)) {
                if (dfsHelper(s.substring(i), wordDict, failed)) return true;
            }
        }
        
        failed.add(s);
        return false;
    } 
     
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) return false;
        Set<String> failed = new HashSet<String>();
        return dfsHelper(s, wordDict, failed);
    }
}
