public class Solution {
    /**
     *  Questions should be asked before coding:
     *  1. What about the last digit of the given number is 0, like 10, 100?
     *  2. What if the reversed Integer overflow?
     */
    public int reverse(int x) {
        if (x == 0) return 0;
        
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        
        // In case of Integer Overflow
        long res = 0;
        while (x > 0) {
            res = 10*res+x%10;
            x /= 10;
        }
        
        res *= sign;
        
        // Deal with Integer overflow
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}
