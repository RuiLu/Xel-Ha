public class Solution {
    // First -> Dynamic Programming
    // dp[i] == true iff dp[j] == true && wordDict.contains(s.substring(j, i))!
    public boolean wordBreak(String s, Set<String> wordDict) {
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;
       
      for (int i = 1; i <= s.length(); i++) {
          for (int j = i - 1; j >= 0; j--) {
              if (dp[j] && wordDict.contains(s.substring(j, i))) {
                  dp[i] = true;
                  break;
              }
          }
      }
       
      return dp[s.length()];
    }
    
    // Second -> DFS
    // Use a set to record all positions that cannot find a match in wordDict
    public boolean wordBreak(String s, Set<String> wordDict) {
        return dfs(s, wordDict, 0, new HashSet<Integer>());
    }
    
    private boolean dfs(String s, Set<String> wordDict, int index, Set<Integer> failed) {
        if (index == s.length()) return true;
        if (failed.contains(index)) return false; // means that there is not match at the position index
        
        for (int i = index + 1; i <= s.length(); i++) {
            String tmp = s.substring(index, i);
            if (wordDict.contains(tmp)) {
                if (dfs(s, wordDict, i, failed)) return true;
                else failed.add(i);
            }
        }
        
        failed.add(index);
        return false;
    }
}
