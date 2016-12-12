public class Solution {
    /**
     *  Idea -> One pass.
     *          Push all 0's to left and all 2's to right.
     *  Time comeplexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            /* we should push 2 to right first */
            while (nums[i] == 2 && right > i) {
                swap(nums, i, right);
                right--;
            }
            while (nums[i] == 0 && left < i) {
                swap(nums, i, left);
                left++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    /**
     *  Idea -> Two passes
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        int count = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) nums[count++] = i;
        }
    }
}
