public class Solution {
    /**
     *  Idea -> Using Map, can use array instead
     *  Time complexity -> O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] map = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            map[sc-'a']++;
            map[tc-'a']--;
        }
        
        for (int num : map) {
            if (num != 0) return false;
        }
        
        return true;
    }
}
