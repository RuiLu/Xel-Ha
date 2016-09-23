public class Solution {
    /**
     *  Greedy
     *  Time complexity -> O(n)
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        
        int max = 0;
        int foot = 0;
        
        for (int i = 0; i < nums.length; i++) {
            max = Integer.max(max, i + nums[i]);
            if (i == foot) {
                foot = max;
            }
            if (foot >= nums.length - 1) return true;
        }
        
        return false;
    }
    
    /**
     *  Backward
     *  Time complexity -> O(n)
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int last = nums.length - 1;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        
        return last <= 0;
    }
}
