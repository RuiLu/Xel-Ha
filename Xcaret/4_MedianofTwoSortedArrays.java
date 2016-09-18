public class Solution {
    /**
     *  ************
     *  Time complexity -> O(log(min(m, n))), where m is length of nums1, n is length of nums2
     *  Reference -> https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation/2
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if (len1 < len2) return findMedianSortedArrays(nums2, nums1);
        
        if (len2 == 0) return (nums1[(len1 - 1) / 2] + nums1[len1 / 2]) / 2.0;
        
        int lo = 0;
        int hi = len2 * 2;
        
        while (lo <= hi) {
            int mid2 = (lo + hi) / 2;
            int mid1 = len1 + len2 - mid2;
            
            double L1 = (mid1 == 0) ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = (mid2 == 0) ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = (mid1 == len1 * 2) ? Double.MAX_VALUE : nums1[mid1 / 2];
            double R2 = (mid2 == len2 * 2) ? Double.MAX_VALUE : nums2[mid2 / 2];
            
            if (L1 > R2) lo = mid2 + 1;
            else if (L2 > R1) hi = mid2 - 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
        }
        
        return -1;
    }
}
