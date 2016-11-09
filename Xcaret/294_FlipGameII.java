public class Solution {
    /**
     *  Idea -> backtracking
     *  Reference -> https://discuss.leetcode.com/topic/27250/share-my-java-backtracking-solution/9
     */
    public static boolean canWin(String s) {
        if (s == null || s.length() < 2) return false;
        Map<String, Boolean> map = new HashMap<>();
        return makeSureCanWin(s, map);
    }
    
    private static boolean makeSureCanWin(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String next = s.substring(0, i) + "--" + s.substring(i + 2);
                
                /* make sure the opponent cannot win. */
                if (!makeSureCanWin(next, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        
        map.put(s, false);
        return false;
    }
}
