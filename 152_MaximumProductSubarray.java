public class Solution {
    /**
     *  1. Track the possible max and min each time, these values can only be obtained 
     *     among max * curr, min * curr and curr
     *  Time complexity -> O(n)
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int max = nums[0], min = nums[0], res = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int maxTmp = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(maxTmp * nums[i], Math.min(min * nums[i], nums[i]));
            if (max > res) res = max;
        }
        
        return res;
    }
}
