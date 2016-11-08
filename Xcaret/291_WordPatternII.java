public class Solution {
    /**
     *  Idea -> Backtracking
     *  Time complexity -> O(m^n), where m is the length of str, n is the length of pattern
     */ 
    private static boolean isMatched(String pat, int i, String str, int j, Map<Character, String> map, Set<String> set) {
        if (pat.length() == i && str.length() == j) return true;
        if (pat.length() == i || str.length() == j) return false;
        
        char curr = pat.charAt(i);
        
        if (map.containsKey(curr)) {
            String s = map.get(curr);
            if (!str.startsWith(s, j)) return false;
            if (isMatched(pat, i + 1, str, j + s.length(), map, set)) return true;
            else return false;
        }
        
        for (int k = j; k < str.length(); k++) {
            String s = str.substring(j, k + 1);
            
            if (set.contains(s)) continue;
            
            map.put(curr, s);
            set.add(s);
            
            if (isMatched(pat, i + 1, str, k + 1, map, set)) return true;
            
            /* backtracking */
            map.remove(curr);
            set.remove(s);
        }
        
        return false;
    }
     
    public static boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatched(pattern, 0, str, 0, map, set);
    }
}
