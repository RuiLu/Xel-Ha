public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }
        int left = 1, right = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length - 1; i++, j--) {
            left *= nums[i];
            right *= nums[j];
            res[i+1] *= left;
            res[j-1] *= right;
        }
        return res;
    }
}
