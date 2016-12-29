public class Solution {
    /**
     * First method -> Iteration
     */ 
    // public boolean isPowerOfTwo(int n) {
    //     if (n == 0) return false;
    //     while (n % 2 == 0) n /= 2;
    //     return n == 1;
    // }
    
    /**
     *  Second method -> Bit manipulation
     */ 
    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n-1)) == 0);
    }
}
