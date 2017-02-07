public class Solution {
    /**
     * Idea -> DFS + Backtracking
     */
    public boolean wordPatternMatch(String pattern, String str) {
        /* key is single character, value is the its corresponding substring */
        Map<Character, String> map = new HashMap<>();
        /* set is used to store substring that is alreay used */
        Set<String> set = new HashSet<>();
        return isMatch(pattern, 0, str, 0, map, set);
    }
    
    private boolean isMatch(String pat, int i, String str, int j, Map<Character, String> map, Set<String> set) {
        /* both pattern and str pointers reach the end */
        if (i == pat.length() && j == str.length()) return true;
        
        /* only one pointer reaches the end, so return false */
        if (i == pat.length() || j == str.length()) return false;
        
        char ch = pat.charAt(i);
        
        /* if map already has the pair for ch */
        if (map.containsKey(ch)) {
            String s = map.get(ch);
            if (!str.startsWith(s, j)) return false;
            return isMatch(pat, i+1, str, j+s.length(), map, set);
        }
        
        for (int k = j; k < str.length(); k++) {
            String s = str.substring(j, k+1);
            
            /* if s has already in the set */
            if (set.contains(s)) continue;
            
            set.add(s);
            map.put(ch, s);
            if (isMatch(pat, i+1, str, k+1, map, set)) return true;
            
            /* backtracking */
            map.remove(ch);
            set.remove(s);
        }
        
        return false;
    }
}
