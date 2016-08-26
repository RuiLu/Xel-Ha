
public class Solution {
    /**
     *  1. Binary Search
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x >= 1 && x <= 3) return 1;
        
        int lo = 1, hi = x;
        
        while (true) {
            int mid = lo + (hi - lo) / 2;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) return mid;
                lo = mid + 1;
            }
        }
    }
    
    /**
     *  2. Newton's method
     */ 
    public int mySqrt(int x) {
        long v = (long)x;
        
        while (v * v > x) {
            v = (v + x / v) >> 1;
        }
        
        return (int)v;
    }
}
