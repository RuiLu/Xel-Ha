public class Solution {
    /**
     *  Idea -> Bit manipulation
     *          If a number is the power of two, there will be only one 1 on the last position of its binary format
     *  Time complexity -> O(32)
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        while (n > 1) {
            if ((n & 1) == 1) return false;
            n >>= 1;
        }
        return n == 1;
    }
}
