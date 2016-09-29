public class Solution {
    /**
     *  Recursion
     *  Time complexity -> O(4^n), the reason is that we have 4 branches in every recursion, the depth is n.
     *  
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        if (s1.equals(s2)) return true;
        
        /* 1. check if both strings contain same character */
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        for (int val : map) {
            if (val != 0) return false;
        }
        
        /* 2. check all possible combinations and permutations */
        for (int i = 1; i < s1.length(); i++) {
            /* i acts as a pivot. */
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        
        return false;
    }
}
