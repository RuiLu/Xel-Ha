public class Solution {
    /**
     *  1. Time complexity -> O(n)
     *     Space complexity -> O(1), in-place
     */
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num != 0) product *= num;
            else zeroCount++;
        }
        
        if (zeroCount >= 2) {
            Arrays.fill(nums, 0);
            return nums;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = product;
            else nums[i] = zeroCount != 0 ? 0 : product / nums[i];
        }
        
        return nums;
    }
    
    /**
     *  2. Two pointers
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        
        int left = 1, right = 1;
        
        for (int i = 0, j = n - 1; i < n - 1 && j > 0; i++, j--) {
            left *= nums[i];
            right *= nums[j];
            res[i + 1] *= left;
            res[j - 1] *= right;
        }
        
        return res;
    }
}
