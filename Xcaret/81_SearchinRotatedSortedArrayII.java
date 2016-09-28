public class Solution {
    /**
     *  Except for the binary search, we should also compare nums[mid] to nums[hi]
     *  Time complexity -> O(logn)
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[hi]) {
                /* in this situation, we can sure that the former part of array is monotonic increasing */
                if (nums[mid] > target && nums[lo] <= target) hi = mid - 1;
                else lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                /* in this situation, we can sure that the latter part of array is monotonic increasing */
                if (nums[mid] < target && nums[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            } else {
                hi--;
            }
        }
        
        return false;
    }
}
