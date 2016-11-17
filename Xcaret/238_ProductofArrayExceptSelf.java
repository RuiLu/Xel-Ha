public class Solution {
    /**
     *  Idea -> first round to count the number of 0s and the total number product(except 0)
     *          second round to calculate the product except self
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int totalProduct = 1;
        int zeroCount = 0;
        int zeroIndex = -1;
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                if (zeroCount == 2) break;
                zeroIndex = i;
            } else {
                totalProduct *= nums[i];
            }
        }
        
        if (zeroCount >= 2) {
            return res;
        } else if (zeroCount == 1) {
            res[zeroIndex] = totalProduct;
            return res;
        } else {
            for (int i = 0; i < nums.length; i++) {
                res[i] = totalProduct / nums[i];
            }
            return res;
        }
    }
}
