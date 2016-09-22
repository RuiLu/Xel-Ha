public class Solution {
    /**
     *  Greedy.
     *  Simple loop.
     *  Time complexity -> O(n)
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        
        int steps = 0;
        int max = 0;
        int stop = 0;
        
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            
            if (i == stop) {
                steps++;
                stop = max;
            }
            
            if (stop >= nums.length - 1) break;
        }
        
        return steps;
    }
    
    /**
     *  Time Limit Exceeded
     */
    // int minStep = Integer.MAX_VALUE;
    
    // public int jump(int[] nums) {
    //     if (nums.length <= 1) return 0;
    //     int pos = 0;
    //     int limit = nums[pos];
    //     helper(nums, pos, limit, 1);
    //     return minStep == Integer.MAX_VALUE ? 0 : minStep;
    // }
    
    // private void helper(int[] nums, int pos, int limit, int steps) {
    //     if (limit == 0) return;
        
    //     if (pos + limit >= nums.length - 1) {
    //         minStep = Math.min(minStep, steps);
    //         return;
    //     }
        
    //     for (int i = pos + 1; i <= Math.min(nums.length - 1, pos + limit); i++) {
    //         helper(nums, i, nums[i], steps + 1);
    //     }
    // }
}
