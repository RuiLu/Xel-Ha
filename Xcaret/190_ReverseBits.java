public class Solution {
    /**
     *  Idea -> At every round, we left shift res one bit.
     *          If lowest bit of n is 1, we add 1 to res, otherwise, add 0 to res.
     *          Then right shift n one bit.
     *  Time complexity -> O(32)
     *  Space complexity -> O(1)
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
       if (n == 0) return 0;
       int res = 0;
       for (int i = 0; i < 32; i++) {
           res <<= 1;
           res += (n & 1);
           n >>= 1;
       }
       return res;
    }
}
