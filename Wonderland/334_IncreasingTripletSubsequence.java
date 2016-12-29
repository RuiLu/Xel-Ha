public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int min_1st = Integer.MAX_VALUE;
        int min_2nd = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; ++i) {
	    // the condition must be smaller or equal to avoid [1,1,1,1,1,....]
            if (nums[i] <= min_1st) {
                min_1st = nums[i];
            } else if (nums[i] <= min_2nd) {
                min_2nd = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
