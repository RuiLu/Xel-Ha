public class Solution {
    public int singleNumber(int[] nums) {
        // 1. easy XOR 
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
        
        // 2. The same idea as 137
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += (nums[j] >> i) & 1;
            }
            result |= (sum % 2) << i;
        }
        return result;
    }
}
