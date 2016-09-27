public class Solution {
    /**
     *  Time complexity -> O(n)
     *  In place.
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        
        int counter = 1;
        int index = 1;
        int curr = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                counter = 1;
                nums[index++] = nums[i];
            } else {
                counter++;
                if (counter <= 2) {
                    nums[index++] = nums[i];
                }
            }
        }
        
        return index;
    }
}
