public class Solution {
    /**
     *  loop
     */
    public boolean isPowerOfFour(int num) {
        while (num / 4 != 0) {
            if (num % 4 != 0) return false;
            num /= 4;
        }
        return num == 1;
    }
    
    /**
     *  Without loop/recursion
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num - 1)) == 0 && (num - 1) % 3 == 0);
    }
}
