public class Solution {
    /**
     *  Bit Manipulation
     *  Idea -> Integer - 32 bits  
     *          So we check numbers one bit by one bit.
     *          If the total number of '1' are divided by 3 in a certern bit position, then we set it to '0'
     *          Otherwise, set it to '1'
     *  Reference -> https://discuss.leetcode.com/topic/35640/java-easy-version-to-understand
     *  Time complexity -> O(32n) ~ O(n)
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        return result;
    }
}
