public class Solution {
    /**
     *  Dynamic Programming
     *  Time complexity -> O(n)
     *  Space complexity -> O(n);
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int include = 0;
        int exclude = 0;
        
        for (int j = 0; j < nums.length; j++) {
            int i = include;
            int e = exclude;
            
            include = e + nums[j];
            exclude = Math.max(i, e);
        }
        
        return Math.max(include, exclude);
    }
}
