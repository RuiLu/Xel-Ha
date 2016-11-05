public class Solution {
    /**
     *  Idea -> Binary Search
     *  Time complexity -> O(logn)
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        
        int len = citations.length;
        int lo = 0;
        int hi = len - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if ((len - mid) <= citations[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return len - lo;
    }
}
