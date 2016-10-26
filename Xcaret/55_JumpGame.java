public class Solution {
    /**
     *  Backward
     *  Time complexity -> O(n)
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        
        int last = nums.length - 1;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        
        return last == 0;
    }
    
    /**
     *  Greedy
     *  Time complexity -> O(n)
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
            if (maxReach <= i) return false;
        }
        
        return false;
    }
}
