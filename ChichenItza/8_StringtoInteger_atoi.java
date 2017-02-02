public class Solution {
    /**
     * Idea -> Situations should be considered:
     *         1. whitespaces
     *         2. +/- sign (assume signs always exist before number)
     *         3. Integer overflow
     *         4. other characters
     */
    public int myAtoi(String str) {
        /* check the invalid input */
        if (str == null || str.length() == 0) return 0;
        
        int sign = 1;
        int sum = 0;
        int idx = 0;
        int len = str.length();
        
        /* 1. remove the leading whitespaces */
        while (idx < len && str.charAt(idx) == ' ') idx++;
        /* check if the string is consists of whitespace */
        if (idx == len) return 0;
        
        /* 2. handle sign */
        if (str.charAt(idx) == '+') {
            idx++;
        } else if (str.charAt(idx) == '-') {
            idx++;
            sign = -1;
        }
        
        /* 3. number conversion */
        while (idx < len && str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
            /* 4. handle Integer Overflow */
            if (sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE/10 && str.charAt(idx)-'0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else if (sign == -1) return Integer.MIN_VALUE;
            }
            sum = sum*10+(str.charAt(idx++)-'0');
        }
        
        return sign*sum;
    }
}
