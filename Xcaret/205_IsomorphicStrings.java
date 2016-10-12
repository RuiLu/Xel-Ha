public class Solution {
    /**
     *  Idea -> using a HashMap to record mapping, and a boolean array to check whether a value is used
     *          Pay attention to the situation s--"ab" and t--"aa", the value 'a' is being used twice.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */ 
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        
        Map<Character, Character> map = new HashMap<>();
        boolean[] used = new boolean[256];
        
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                if (used[tc]) return false;
                map.put(sc, tc);
                used[tc] = true;
            } else {
                if (map.get(sc) != tc) return false;
            }
        }
        
        return true;
    }
}
