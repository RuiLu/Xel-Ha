public class Solution {
    /**
     *  Idea -> Binary Search.
     *          Be careful with the corner case.
     *  Time complexity -> O(logn)
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        
        int lo = 0;
        int hi = nums.length-1;
        
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if ((mid == 0 || nums[mid] > nums[mid-1]) &&
                (mid == nums.length-1 || nums[mid] > nums[mid+1])) { // If the nums[mid] is peak
                return mid;
            } else if (mid > 0 && nums[mid] < nums[mid-1]) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        
        return lo;
    }
}
