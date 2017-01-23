public class Solution {
    /**
     *  Idea -> Dynamic Programming
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(n)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        
        Set<String> set = new HashSet<>();
        for (String word : wordDict) set.add(word);
        
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = i-1; j >= 0; j--) {
                String next = s.substring(j, i);
                /* check whether substring from j to i-1 is in set of not.
                 * if so, assign value of dp[j] to dp[i].
                 * if both dp[i] and dp[j] are true,
                 * meaning that both subtrings from 0 to j-1 and from j to i-1 are in set. */
                 if (set.contains(next)) {
                     dp[i] = dp[j];
                     if (dp[i]) break;
                 }
            }
        }
        
        return dp[len];
    }
    
    /**
     *  Idea -> DFS + Memorization
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        Set<String> set = new HashSet<>();
        for (String word : wordDict) set.add(word);
        Set<String> failed = new HashSet<>();
        return dfs(s, set, failed);
    }
    
    private boolean dfs(String s, Set<String> set, Set<String> failed) {
        /* reach the end of s, means find word break successfully */
        if (s.equals("")) return true;
        /* use memorization to block out the failed s */
        if (failed.contains(s)) return false;
        
        /* check word in set one by one to see if the current string starts with the given word */
        for (String word : set) {
            if (s.startsWith(word)) {
                if (dfs(s.substring(word.length()), set, failed)) return true;
            }
        }
        
        failed.add(s);
        return false;
    }
}
