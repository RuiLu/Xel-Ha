public class Solution {
    /**
     *  Backtrackinh 
     *  Reference -> https://discuss.leetcode.com/topic/26750/share-my-java-backtracking-solution/2
     */
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        return isMatch(pattern, 0, str, 0, map, set);
    }
    
    private boolean isMatch(String pat, int i, String str, int j, Map<Character, String> map, Set<String> set) {
        if (i == pat.length() && j == str.length()) return true;
        if (i == pat.length() || j == str.length()) return false;
        
        char curr = pat.charAt(i);
        
        // have current character in map
        if (map.containsKey(curr)) {
            String s = map.get(curr);
            
            if (!str.startsWith(s, j)) return false;
            
            return isMatch(pat, i + 1, str, j + s.length(), map, set);
        }
        
        // does not have current character in map, so we do match test one by one
        for (int k = j; k < str.length(); k++) {
            String s = str.substring(j, k + 1);
            
            if (set.contains(s)) continue;
            
            map.put(curr, s);
            set.add(s);
            
            if (isMatch(pat, i + 1, str, k + 1, map, set)) return true;
            
            // backtracking
            map.remove(curr);
            set.remove(s);
        }
        
        return false;
    }
}
