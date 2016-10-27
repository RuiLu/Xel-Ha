public class Solution {
    /**
     *  Record the start position and end position
     *  Time complexity -> O(n^2) in worst case, where n is the length of input string
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        
        int lo = 0;
        int hi = 0;
        int maxLen = Integer.MIN_VALUE;
        char[] sca = s.toCharArray();
        int len = sca.length;
        
        for (int i = 0; i < len; i++) {
            // for odd length
            for (int j = 0; (i - j >= 0) && (i + j < len) && sca[i-j] == sca[i+j]; j++) {
                if (maxLen < 2 * j + 1) {
                    lo = i - j;
                    hi = i + j;
                    maxLen = 2 * j + 1;
                }
            }
            
            // for even length
            for (int j = 1; (i - j + 1 >= 0) && (i + j < len) && sca[i-j+1] == sca[i+j]; j++) {
                if (maxLen < 2 * j) {
                    lo = i - j + 1;
                    hi = i + j;
                    maxLen = 2 * j;
                }
            }
        }
        
        return s.substring(lo, hi + 1);
    }
    
    /**
     *  Time Limited Exceeded
     *  Time complexity -> O(n^2)
     */
    // public String longestPalindrome(String s) {
    //     String res = "";
        
    //     if (s == null || s.length() == 0) return res;
    //     if (s.length() == 1) return s;
        
    //     int len = s.length();
    //     int maxLen = Integer.MIN_VALUE;
        
    //     for (int i = 0; i < len; i++) {
    //         for (int j = i; j < len; j++) {
    //             String str = s.substring(i, j + 1);
    //             if (isPalindrome(str)) {
    //                 if (maxLen <= j - i + 1) {
    //                     maxLen = j - i + 1;
    //                     res = str;
    //                 }
    //             }
    //         }
    //     }
        
    //     return res;
    // }
    
    // private boolean isPalindrome(String s) {
    //     int lo = 0;
    //     int hi = s.length() - 1;
        
    //     while (lo < hi) {
    //         if (s.charAt(lo) != s.charAt(hi)) return false;
    //         lo++;
    //         hi--;
    //     }
        
    //     return true;
    // }
}

