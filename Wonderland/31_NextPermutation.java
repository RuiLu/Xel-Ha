/**
 *  Search the array from right to left to find the first element that nums[i] < nums[i+1]
 *  Then find a element from i + 1 to len - 1 whose value is less or equal to nums[i], swap
 *  Finally, reverse the order from i + 1 to len - 1
 */
public class Solution {
    
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 2) return;
        int i = nums.length - 2;
        
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        
        // Only when i >= 0, if i < 0, mean nums is in completely reverse order
        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[i] < nums[j]) j++;
            j--;
            swap(nums, i, j);
        }
        
        reverseOrder(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverseOrder(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

}
