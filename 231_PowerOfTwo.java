public class Solution {
    public boolean isPowerOfTwo(int n) {
        // 1. iterative
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
        
        // 2. bit manipulation
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
