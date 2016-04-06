/*
 * Actually, not good at Bit Manipulation, still need to work on it.
 * Reference: https://leetcode.com/discuss/83132/java-easy-version-to-understand
 * Brilliant idea from: https://leetcode.com/discuss/81165/explanation-manipulation-method-might-easier-understand
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += (nums[j] >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        return result;
    }
}
