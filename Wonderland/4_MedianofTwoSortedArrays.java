
public class Solution {
    /**
     *  Time comlexity -> O(log(m+n))
     */ 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if ((m + n) % 2 != 0) {
            return findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1);
        } else {
            double res1 = findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1);
            double res2 = findKth(nums1, nums2, (m + n) / 2 - 1, 0, m - 1, 0, n - 1);
            return (res1 + res2) / 2.0;
        }
    }
    
    private double findKth(int[] a, int[] b, int k, int as, int ae, int bs, int be) {
        int aLen = ae - as + 1;
        int bLen = be - bs + 1;
        if (aLen == 0) return b[bs + k];
        if (bLen == 0) return a[as + k];
        if (k == 0) return Math.min(a[as], b[bs]);
        
        int aMid = k * aLen / (aLen + bLen);
        int bMid = k - aMid - 1;
        
        aMid = as + aMid;
        bMid = bs + bMid;
        
        if (a[aMid] > b[bMid]) {
            k = k - (bMid - bs + 1);
            bs = bMid + 1;
            ae = aMid;
        } else {
            k = k - (aMid - as + 1);
            as = aMid + 1;
            be = bMid;
        }
        
        return findKth(a, b, k, as, ae, bs, be);
    }
    
    /**
     *  Time complexity -> O(log(min(m, n)))
     *  ref -> https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/14
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1); // find min(m, n)
        
        int minIndex = 0, maxIndex = m;
        int res1 = 0, res2 = 0;
        int i = 0, j = 0;
        int mid = (m + n + 1) >> 1; // divided by 2
        
        while (minIndex <= maxIndex) {
            i = (minIndex + maxIndex) >> 1;
            j = mid - i;
            
            if (i > 0 && j < n && nums2[j] < nums1[i - 1]) maxIndex = i - 1;
            else if (j > 0 && i < m && nums1[i] < nums2[j - 1]) minIndex = i + 1;
            else {
                if (i == 0) res1 = nums2[j - 1];
                else if (j == 0) res1 = nums1[i - 1];
                else res1 = Math.max(nums1[i - 1], nums2[j - 1]);
                break;
            }
        }
        
        if ((m + n) % 2 != 0) return res1;
        if (i == m) res2 = nums2[j];
        else if (j == n) res2 = nums1[i];
        else res2 = Math.min(nums1[i], nums2[j]);
        return (res1 + res2) / 2.0;
    }
     
}
