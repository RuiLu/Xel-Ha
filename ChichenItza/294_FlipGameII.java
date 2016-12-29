public class Solution {
    /**
     *  Idea -> DFS + Memorization
     *  Time complexity -> O(n!!), so much time
     */
    public boolean canWin(String s) {
        if (s == null || s.length() <= 1) return false;
        HashMap<String, Boolean> map = new HashMap<>();
        return canWin(s, map);
    }
    
    private boolean canWin(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i+2).equals("++")) {
                String next = s.substring(0, i) + "--" + s.substring(i+2);
                if (!canWin(next, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
