public class Solution {
    /**
     *  Idea -> Maintain the two variables. One is 1st smallest element, another one is 2nd smallest element.
     *  Time complexity -> O(n)
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min1) {          
                min1 = nums[i];             // min1 is the minimum number seen so far
            } else if (nums[i] <= min2) {   // if nums[i] > min1 && nums[i] <= min2, nums[i] might be min2 or min3
                min2 = nums[i];             // nums[i] is smaller than current min2, store it.
            } else {                        // here, when we already have c1 < c2, and nums[i] > c2
                return true;                // find the increasing triplet subsequence
            }
        }
        
        return false;
    }
}
