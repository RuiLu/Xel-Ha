public class Solution {
    /**
     *  Idea -> Bit manipulation
     *  Reference -> https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length <= 2) return nums;
        
        // pass 1 : get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) diff ^= num;
        
        // find the rightmost set bit
        diff &= (-diff);
        
        // pass 2 :
        int[] res = new int[]{0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) res[0] ^= num;   // the bit is not set
            else res[1] ^= num;                     // the bit is set
        }
        
        return res;
    }
}
