public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     *  Idea -> put 5 into nums[4], put 4 into nums[3], etc, then check then nums, once nums[i] != i + 1, found answer
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        
        return nums.length + 1;
    }
}
