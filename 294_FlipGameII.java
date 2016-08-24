public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/27250/share-my-java-backtracking-solution/9
     *  1. use Map<String, Boolean> to store the known result;
     *  2. use canWin(next, map) to indicate whether the opponent can win, next means the state for opponent to play
     * 
     *  Time complexity -> O(n!!), since we use Map to de-duplicate, much time will be saved
     *  Space complexity -> O(2^n), since the maxium possible number of permutations of s is 2^n, where n is the length
     */
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) return false;
        Map<String, Boolean> map = new HashMap<>();
        return canWin(s, map);
    }
    
    private boolean canWin(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String next = s.substring(0, i) + "--" + s.substring(i + 2);
                
                // if the opponent cannot win, we win
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
