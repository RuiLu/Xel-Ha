public class Solution {
    /**
     *  Idea -> Record the start position and end position
     *  Time complexity -> O(n^2) in worst case, where n is the length of input string
     */ 
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        
        int lo = 0;
        int hi = 0;
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            /* first check substring with odd length */
            for (int j = 0; i-j >= 0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j); j++) {
                int len = 2*j+1;
                if (len > maxLen) {
                    lo = i - j;
                    hi = i + j;
                    maxLen = len;
                }
            }
            /* then check substring with even length */
            for (int j = 1; i-j+1 >= 0 && i+j < s.length() && s.charAt(i-j+1) == s.charAt(i+j); j++) {
                int len = 2*j;
                if (len > maxLen) {
                    lo = i - j + 1;
                    hi = i + j;
                    maxLen = len;
                }
            }
        }
        
        return s.substring(lo, hi + 1);
    }
}
