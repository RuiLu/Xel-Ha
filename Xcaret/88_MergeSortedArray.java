public class Solution {
    /**
     *  One pass, from big to small
     *  Space complexity -> O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        /* from tail to start, so will not affect the previous number */
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        /**
         *  if i >= 0 while j < 0, the desired order is the same as the original order of nums1, so we only
         *  need to consider the situation where j >= 0 while i < 0
         */
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    } 
    
    /**
     *  Two passes
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m + n > nums1.length) {
            return;
        }
        int[] tmp = new int[m+n];
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (nums1[i] >= nums2[j]) {
                    tmp[count++] = nums2[j++];
                } else {
                    tmp[count++] = nums1[i++];
                }
            } else if (i == m) {
                tmp[count++] = nums2[j++];
            } else if (j == n) {
                tmp[count++] = nums1[i++];
            }
        }
        
        for (i = 0; i < tmp.length; i++) {
            nums1[i] = tmp[i];
        }
    }
}
