public class Solution {
    /**
     *  Idea -> Binary Search
     *          The only thing should be noted is to avoid Integer overflow
     */
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x == 1) return 1;
        
        long n = (long)x;
        long hi = x/2;
        long lo = 1;
        
        while (lo < hi) {
            long mid = lo+(hi-lo)/2;
            if (mid*mid == n) return (int)mid;
            else if (mid*mid > n) hi = mid;
            else {
                if ((mid+1)*(mid+1) > n) return (int)mid;
                lo = mid+1;
            }
        }
        
        return (int)lo;
    }
}
