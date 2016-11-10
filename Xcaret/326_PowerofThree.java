public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        
        while (n != 1) {
            if (n == 0 || n % 3 != 0) return false;
            n /= 3;
        }
        
        return true;
    }
}
