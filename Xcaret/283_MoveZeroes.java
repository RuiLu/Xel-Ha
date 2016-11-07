public class Solution {
    /**
     *  Idea -> Move all non-0 elements ahead, and set other positions to 0
     *  Time complexity -> O(n)
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
