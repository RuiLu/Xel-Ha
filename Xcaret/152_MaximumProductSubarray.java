public class Solution {
    /**
     *  We traverse the array, keeping tracks of current max and current min
     *  Because the maximum product is created by the maximum values among curr, curr * min and curr * max
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int maxTmp = max;
            max = Math.max(curr, Math.max(min * curr, max * curr));
            min = Math.min(curr, Math.min(min * curr, maxTmp * curr));
            res = Math.max(res, max);
        }
        
        return res;
    }
}
