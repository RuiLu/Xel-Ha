public class Solution {
    /**
     *  Idea -> first round to count the number of 0s and the total number product(except 0)
     *          second round to calculate the product except self
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int product = 1;
        int zeroCount = 0;
        
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                if (zeroCount == 2) return res;
                continue;
            }
            product *= num;
        }
        
        if (zeroCount == 1) {
            for (int i = 0; i < len; i++) {
                if (nums[i] == 0) res[i] = product;
            }
        } else {
            for (int i = 0; i < len; i++) {
                res[i] = product / nums[i];
            }
        }
        
        return res;
    }
}
