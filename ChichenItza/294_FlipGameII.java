public class Solution {
    /**
     *  Idea -> DFS + Memorization
     *  Time complexity -> O(n!!), so much time
     */
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) return false;
        HashMap<String, Boolean> memorization = new HashMap<>();
        return canWin(s, memorization);
    }
    
    private boolean canWin(String s, HashMap<String, Boolean> memorization) {
        if (memorization.containsKey(s)) return memorization.get(s);
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i+2).equals("++")) {
                String next = s.substring(0, i) + "--" + s.substring(i+2);
                /* if the opponent cannot win, then I can win */
                if (!canWin(next, memorization)) {
                    memorization.put(s, true);
                    return true;
                }
            }
        }
        
        /* If I cannot win, then the opponent can win. */
        memorization.put(s, false);
        return false;
    }
}
