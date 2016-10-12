public class Solution {
    /**
     *  Two pointers
     *  Time complexity -> O(n) worst case
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int runner = 0;
        int walker = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        while (runner < nums.length) {
            sum += nums[runner];
            
            while (sum >= s) {
                minLen = Math.min(minLen, runner - walker + 1);
                sum -= nums[walker++];
            }
            
            runner++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
}
