public class Solution {
    /**
     *  Binary search
     *  Time complexity -> O(logx)
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        
        int lo = 0;
        int hi = x;
        
        while (true) {
            int mid = (lo + hi) / 2;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                }
                lo = mid + 1;
            }
        }
    }
}
