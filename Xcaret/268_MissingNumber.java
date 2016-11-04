public class Solution {
    /**
     *  Idea -> put every number into the right position, like nums[i] = i
     *          then traverse the array to find anomaly
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i || nums[i] == nums.length) continue;
            
            while (nums[i] != i && nums[i] != nums.length) {
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        
        return nums.length;
    }
}
