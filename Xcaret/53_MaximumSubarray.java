public class Solution {
    /**
     *  Dynamic Programming
     *  Time complexity -> O(n)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxSum = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            dp[i+1] = Math.max(nums[i], nums[i] + dp[i]);
            maxSum = Math.max(maxSum, dp[i+1]);
        }
        
        return maxSum;
    } 
    
    /**
     *  Divide and Conquer
     *  Time complexity -> O(nlogn)
     *  Reference -> https://discuss.leetcode.com/topic/426/how-to-solve-maximum-subarray-by-using-the-divide-and-conquer-approach/2
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    
    private int helper(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];
        
        int mid = (lo + hi) / 2;
        
        /* 1. if the result does not contain the mid point */
        int left = helper(nums, lo, mid);
        int right = helper(nums, mid + 1, hi);
        
        /* 2. if the result does contain the mid point */
        int leftMax = nums[mid];
        int rightMax = nums[mid + 1];
        
        int tmp = 0;
        for (int i = mid; i >= lo; i--) {
            tmp += nums[i];
            leftMax = Math.max(leftMax, tmp);
        }
        
        tmp = 0;
        for (int i = mid + 1; i <= hi; i++) {
            tmp += nums[i];
            rightMax = Math.max(rightMax, tmp);
        }
        
        /* compare the above two situations, and find the larger answer */
        return Math.max(Math.max(left, right), leftMax + rightMax);
    }
    
    /**
     *  Time complexity -> O(n^2)
     *  Time Limit Exceeded
     */
    // public int maxSubArray(int[] nums) {
    //     if (nums == null || nums.length == 0) return 0;
        
    //     int maxSum = Integer.MIN_VALUE;
        
    //     for (int i = 0; i < nums.length; i++) {
    //         int tmp = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             tmp += nums[j];
    //             maxSum = Math.max(maxSum, tmp);
    //         }
    //     }
        
    //     return maxSum;
    // }
}
