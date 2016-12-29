public class Solution {
    
    public boolean isScramble(String s1, String s2) {
        
        if (s1.equals(s2)) return true;
        
        int[] alphabet = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alphabet[s1.charAt(i) - 'a']++;
            alphabet[s2.charAt(i) - 'a']--;
        }
        
        for (int i : alphabet) {
            if (i != 0) return false;
        }
        
        // must start from i = 1, coz we use substring() here
        for (int i = 1; i < s1.length(); i++) {
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
