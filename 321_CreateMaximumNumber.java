public class Solution {
    /**
     *  Hard...
     *  Reference -> https://discuss.leetcode.com/topic/32272/share-my-greedy-solution/2
     *  General Idea ->
     *  1. Find all possible combinations from nums1 and nums2 (getMaxArray and merge)
     *  2. Figure out which one is the largest one
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[k];
        
        for (int i = Math.max(0, k - len2); i <= k && i <= len1; i++) {
            int[] maxSubArray1 = getMaxArray(nums1, i);
            int[] maxSubArray2 = getMaxArray(nums2, k - i);
            int[] candidate = merge(maxSubArray1, maxSubArray2, k);
            if (greater(candidate, 0, res, 0)) res = candidate;
        }
        
        return res;
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        
        /* Is equal or nums1 is greater than nums2 */
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int idx1 = 0;
        int idx2 = 0;
        
        for (int r = 0; r < k; r++) {
            res[r] = greater(nums1, idx1, nums2, idx2) ? nums1[idx1++] : nums2[idx2++];
        }
        
        return res;
    }
    
    private int[] getMaxArray(int[] nums, int k) {
        int[] res = new int[k];
        int len = nums.length;
        
        for (int i = 0, j = 0; i < len; i++) {
            while (len - i + j > k && j > 0 && res[j - 1] < nums[i]) j--;
            if (j < k) res[j++] = nums[i];
        }
        
        return res;
    }
}
