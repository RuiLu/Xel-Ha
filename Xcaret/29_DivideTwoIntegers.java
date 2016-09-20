public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/15568/detailed-explained-8ms-c-solution
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        
        int res = 0;
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ?
                             true : false;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        
        while (dvs <= dvd) {
            long tmp = dvs;
            long mul = 1;
            
            while ((tmp << 1) <= dvd) {
                tmp <<= 1;
                mul <<= 1;
            }
            
            dvd -= tmp;
            res += mul;
        }
        
        return isNegative ? -res : res;
    }

}
