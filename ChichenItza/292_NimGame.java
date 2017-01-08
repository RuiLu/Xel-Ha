public class Solution {
    public boolean canWinNim(int n) {
        if (n <= 3) return true;
        /* Create a HashMap for memorization, speeding up the process. */
        HashMap<Integer, Boolean> map = new HashMap<>();
        return canWinNim(n, map);
    }
    
    private boolean canWinNim(int n, HashMap<Integer, Boolean> map) {
        if (map.containsKey(n)) return map.get(n);
        
        /* If n <= 3, I can win for sure. */
        if (n <= 3) {
            map.put(n, true);
            return true;
        }
    
        /* Check all three possible next steps for next players, If he/she cannot win, then i can win. */
        for (int i = 1; i <= 3; i++) {
            if (!canWinNim(n-i, map)) {
                map.put(n, true);
                return true;
            }
        }
        
        map.put(n, false);
        return false;
    }
}
