public class Solution {
    /**
     *  Idea -> Bit manipulation
     *  Time complexity -> O(1)
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count == 1;
    } 
     
    /**
     *  Idea -> Recursion.
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;       // Should consider the situation with n == 0
        if (n == 1) return true;
        if (n%2 != 0) return false;
        return isPowerOfTwo(n/2);
    }
}
