public class Solution {
    /**
     *  Idea -> Bit manipulation
     *  Reference -> https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        
        int diff = 0;
        
        // pass 1: do XOR operation to all numbers
        for (int num : nums) diff ^= num;
        
        // find the rightmost set bit
        diff &= (-diff);
        
        int[] res = new int[2];
        
        // pass 2: divide nums into two groups according to set bit, do XOR operation to each group
        for (int num : nums) {
            if ((num&diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        
        return res;
    }
}
