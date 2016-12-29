public class Solution {
    /**
     *  Backtracking + dp
     */
    public boolean canWinNim(int n) {
        if (n <= 3) return true;
        Map<Integer, Boolean> map = new HashMap<>();
        return canWinNim(n, map);
    }
    
    private boolean canWinNim(int n, Map<Integer, Boolean> map) {
        if (map.containsKey(n)) return map.get(n);
        
        if (n <= 3) {
            map.put(n, true);
            return true;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (!canWinNim(n - i)) {
                map.put(n, true);
                return true;
            }
        }
        
        map.put(n, false);
        return false;
    }
    
    /**
     *  Theorem 
     *  Reference -> https://discuss.leetcode.com/topic/26999/theorem-all-4s-shall-be-false
     */ 
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
