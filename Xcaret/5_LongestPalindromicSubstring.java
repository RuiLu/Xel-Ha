public class Solution {
    /**
     *  Record the start position and end position
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        
        int sLen = s.length();
        int max = Integer.MIN_VALUE;
        int lo = 0;
        int hi = 0;
        
        for (int i = 0; i < sLen; i++) {
            /* Odd length */
            for (int j = 0; i - j >= 0 && i + j < sLen && s.charAt(i - j) == s.charAt(i + j); j++) {
                int len = j * 2 + 1;
                if (max < len) {
                    max = len;
                    lo = i - j;
                    hi = i + j + 1;
                }
            }
            
            /* Even length */
            for (int j = 1; i - j + 1 >= 0 && i + j < sLen && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
                int len = 2 * j;
                if (max < len) {
                    max = len;
                    lo = i - j + 1;
                    hi = i + j + 1;
                }
            }
        }
        
        return s.substring(lo, hi);
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

