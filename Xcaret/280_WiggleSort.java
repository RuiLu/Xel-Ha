public class Solution {
    /**
     *  Idea -> Always keey the element in the even position smaller or equal to its adjacent elements (odd positions)
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
   
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                if (nums[i] < nums[i-1]) swap(nums, i, i - 1);
            } else {
                if (i > 0 && nums[i] > nums[i-1]) swap(nums, i, i - 1);
            }
        }
    }
}
