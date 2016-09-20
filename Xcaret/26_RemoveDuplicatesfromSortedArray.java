public class Solution {
    /**
     *  Create a unique index counter
     *  Time complexity -> O(n)
     *  In space
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int idx = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) continue;
            nums[idx++] = nums[i];
        }
        
        return idx;
    }
}
