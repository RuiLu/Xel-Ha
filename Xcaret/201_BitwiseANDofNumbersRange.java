public class Solution {
    /**
     *  Idea -> 1. The last bit of (odd number & even number) is always 0
     *          2. when m != n, there is at least an odd number and an even number, so the last bit is 0
     *          3. when m != n, right shift m and n one bit, and left shift moveFactor one bit, until m == n
     *  Time complexity -> O(32) -> O(1)
     *  Reference -> https://discuss.leetcode.com/topic/12133/bit-operation-solution-java
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m > n || m == 0) return 0;
        if (m == n) return m;
        
        int moveFactor = 1;
        
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        
        return m * moveFactor;
    }
}
