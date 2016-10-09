public class Solution {
    /**
     *  We traverse the array, keeping tracks of current max and current min
     *  Because the maximum product is created by the maximum values among curr, curr * min and curr * max
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int maxTmp = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(maxTmp * nums[i], Math.min(min * nums[i], nums[i]));
            res = Math.max(res, max);
        }
        
        return res;
    }
}
