public class Solution {
    /**
     *  Idea -> dynamic programming
     *  Time complexity -> O(n)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    
    private int helper(int[] nums, int begin, int end) {
        int include = 0;
        int exclude = 0;
        
        for (int j = begin; j <= end; j++) {
            int i = include;
            int e = exclude;
            include = e + nums[j];
            exclude = Math.max(e, i);
        }
        
        return Math.max(include, exclude);
    }
}
