public class Solution {
    /**
     *  Binary search -> Time complexity -> O(logn)
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        if (citations.length == 1) return citations[0] == 0 ? 0 : 1;
        
        int len = citations.length;
        int lo = 0;
        int hi = len - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ((len - mid) == citations[mid]) return citations[mid];
            else if ((len - mid) > citations[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return len - (hi + 1);
    }
}
