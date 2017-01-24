public class Solution {
    /**
     * Idea -> Situations should be considered:
     *         1. whitespaces
     *         2. +/- sign (assume signs always exist before number)
     *         3. Integer overflow
     *         4. other characters
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        
        int sign = 1;
        int base = 0;
        int i = 0;
        
        /* 1. remove the leading whitespaces */
        while (i < str.length() && str.charAt(i) == ' ') i++;
        /* if str is consist of whitespaces, return 0 */
        if (i == str.length()) return 0;
        
        /* 2. handle sign */
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            /* true's value is 1, false's value is 0 */
            sign = 1 - 2*(str.charAt(i++) == '-' ? 1 : 0);
        }
        
        /* 3. number conversion */
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            /* avoid Integer Overflow */
            if (base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && str.charAt(i)-'0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else if (sign == -1) return Integer.MIN_VALUE;
            }
            base = base*10+(str.charAt(i++)-'0');
        }
        
        return base*sign;
    }
}
