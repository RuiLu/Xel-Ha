public class Solution {
    /**
     * Idea -> Two pointers.
     * Time complexity -> O(n)
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0; 
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        
        while (right < nums.length) {
            /* first, add current element into sum, move right forward */
            sum += nums[right++];
            /* second, if current sum is bigger than or equal to s, 
             * calculate length, minus element on left and move left forward */
            while (left <= right && sum >= s) {
                minLen = Math.min(minLen, right-left);
                sum -= nums[left++];
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
