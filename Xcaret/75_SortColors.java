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
        
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }
        
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                nums[idx++] = i;
            }
        }
    }
}
