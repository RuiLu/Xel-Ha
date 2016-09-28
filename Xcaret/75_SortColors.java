public class Solution {
    /**
     *  Using one pass with constant space
     *  Swipe all 0s to left and all 2s to right
     *  Time complexity -> O(n)
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int left = 0;
        int right = nums.length - 1;
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 2 && i < right) {
                swap(nums, i, right);
                right--;
            }
            while (nums[i] == 0 && i > left) {
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
     *  Using two passes, counting sort.
     *  Time complexity -> O(2n)
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int[] colors = new int[3];
        int count = 0;
        for (int num : nums) {
            colors[num]++;
        }
        for (int i = 0; i < 3; i++) {
            while (colors[i]-- > 0) {
                nums[count++] = i;
            }
        }
    }
}
