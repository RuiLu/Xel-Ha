public class Solution {
    /**
     *  Hard...
     *  Reference -> https://discuss.leetcode.com/topic/32272/share-my-greedy-solution/2
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[k];
        
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] maxSubArray1 = maxArray(nums1, i);
            int[] maxSubArray2 = maxArray(nums2, k - i);
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
    
    private int[] merge(int[] nums1, int[] nums2, int len) {
        int[] res = new int[len];
        
        for (int i = 0, j = 0, k = 0; k < len; k++) {
            res[k] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        
        return res;
    }
    
    private int[] maxArray(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[k];
        
        for (int i = 0, j = 0; i < len; i++) {
            while (len - i + j > k && j > 0 && res[j - 1] < nums[i]) j--;
            if (j < k) res[j++] = nums[i];
        }
        
        return res;
    }
}
