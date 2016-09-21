public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/15568/detailed-explained-8ms-c-solution
     *  We can take 15 / 3 = 5 as an example:
     *  Firsr round:
     *  intialize -> 3  (mul == 1)
     *  3 >> 1 == 6     (mul == 2)
     *  6 >> 1 == 12    (mul == 4) -> res += mul == 4
     *  12 >> 1 == 24 >= 15
     *  So, dvd -= tmp -> 15 -= 12 -> 3
     *  Second round:
     *  initialize -> 3 (mul == 1) -> res += mul == 5
     *  3 >> 1 == 6 >= 3
     *  Therefore, we get the result.
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        
        int res = 0;
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        
        while (dvs <= dvd) {
            long tmp = dvs;
            int mul = 1;
            
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
