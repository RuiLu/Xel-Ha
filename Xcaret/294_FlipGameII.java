public class Solution {
    /**
     *  Idea -> backtracking
     *  Reference -> https://discuss.leetcode.com/topic/27250/share-my-java-backtracking-solution/9
     */
    private static boolean makeSureCanWin(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (prev == curr && curr == '+') {
                String next = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                
                /* Make sure that the opponent cannot win */
                if (!makeSureCanWin(next, map)) {
                    map.put(s, true);
                    return true;
                }
            }
            
            prev = curr;
        }
        
        map.put(s, false);
        return false;
    }
     
    public static boolean canWin(String s) {
        if (s == null || s.length() < 2) return false;
        Map<String, Boolean> map = new HashMap<>();
        return makeSureCanWin(s, map);
    }
}
