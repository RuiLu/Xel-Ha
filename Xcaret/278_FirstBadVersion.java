/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    /**
     *  Idea -> Binary Search, but pay attention to the Integer Overflow
     *  Time complexity -> O(logn)
     */
    public int firstBadVersion(int n) {
        if (n == 1) return 1;
        long lo = 1;
        long hi = n;
        
        while (lo <= hi) {
            int mid = (int)((lo + hi) / 2);
            if (isBadVersion(mid)) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return (int)lo;
    }
}
