public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if (s == null || s.length() == 0) return res;
        if (s.length() == 1) return s;
        for (int i = 0; i < s.length(); i++) {
            // for the length is odd
            String temp = findPalindrome(s, i, i);
            if (temp.length() > res.length()) res = temp;
            // for the length is even
            temp = findPalindrome(s, i, i + 1);
            if (temp.length() > res.length()) res = temp;
        }
        return res;
    }
    
    private String findPalindrome(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
    
}
