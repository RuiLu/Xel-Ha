public class Solution {
    /**
     *  Bitwise way
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
    
    /**
     *  Naive way. Time limited Exceeded
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= (n-1);
        }       
        return n;
    }
}
