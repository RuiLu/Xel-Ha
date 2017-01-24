public class Solution {
    /**
     * Idea -> 1. The length of repeating substring must be a divisor of the length of the original string
     *         2. Find all possible substrings whose length are divisors of the length of the original string
     *         3. Sublen is the potential length of substring, times=len/sublen is the number of substring.
     *         4. Test the result to check is combined result is equal to the original input.
     */
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() <= 1) return false;
        
        int len = str.length();
        
        for (int subLen = len/2; subLen >= 1; subLen--) {
            if (len%subLen == 0) {
                int times = len/subLen;
                String sub = str.substring(0, subLen);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < times; i++) sb.append(sub);
                if (sb.toString().equals(str)) return true;
            }
        }
        
        return false;
    }
    
    /**
     * Idea -> Recursion -> TLE
     */
    // public boolean repeatedSubstringPattern(String str) {
    //     if (str == null || str.length() <= 1) return false;
    //     for (int i = 1; i <= str.length()/2; i++) {
    //         String sub = str.substring(0, i);
    //         if (helper(str.substring(i), sub)) return true;
    //     }
    //     return false;
    // }
    
    // private boolean helper(String s, String p) {
    //     if (s.equals("")) return true;
    //     if (s.startsWith(p)) return helper(s.substring(p.length()), p);
    //     return false;
    // }
}
