public class Solution {
    /**
     *  Hard...
     *  Reference -> https://discuss.leetcode.com/topic/32272/share-my-greedy-solution/2
     *  General Idea ->
     *  1. Find all possible combinations from nums1 and nums2 (getMaxArray and merge)
     *  2. Figure out which one is the largest one
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        for (int i = Math.max(0, k - len2); i <= k && i <= len1; i++) {
            int[] subMaxArray1 = getSubMaxArray(nums1, i);
            int[] subMaxArray2 = getSubMaxArray(nums2, k - i);
            int[] candidate = merge(subMaxArray1, subMaxArray2, k);
            if (greater(candidate, 0, res, 0)) res = candidate;
        }
        
        return res;
    }
    
    private boolean greater(int[] nums1, int len1, int[] nums2, int len2) {
        while (len1 < nums1.length && len2 < nums2.length && nums1[len1] == nums2[len2]) {
            len1++;
            len2++;
        }
        
        return len2 == nums2.length || (len1 < nums1.length && nums1[len1] > nums2[len2]);
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        
        return res;
    }
    
    private int[] getSubMaxArray(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[k];
        
        for (int i = 0, j = 0; i < len; i++) {
            while (len - i + j > k && j > 0 && res[j - 1] < nums[i]) j--;
            if (j < k) res[j++] = nums[i];
        }
        
        return res;
    }
}
