public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/36150/1-line-java-solution-without-loop-recursion
     */
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
	/**
         * first
         */
        // return (n > 0 && 1162261467 % n == 0);
        
        /**
         * second
         */
        return n > 0 && ((int)Math.pow(3, (int)(Math.log(Integer.MAX_VALUE) / Math.log(3.0))) % n == 0);        
    }
}
