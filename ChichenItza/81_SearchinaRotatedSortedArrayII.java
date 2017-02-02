public class Solution {
    /**
     * Idea -> Find the halp part which is monotonically increasing
     * Time complexity -> O(logn)
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        
        int lo = 0;
        int hi = nums.length-1;
        
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (nums[mid] == target) return true;
            
            /* we need to find which half part is monotonically increasing. */
            if (nums[mid] > nums[hi]) {
                /* make sure that the first half part is monotonically increasing */
                if (nums[lo] <= target && nums[mid] > target) hi = mid-1;
                else lo = mid+1;
            } else if (nums[mid] < nums[hi]) {
                /* make sure that the second half part is monotonically increasing */
                if (nums[hi] >= target && nums[mid] < target) lo = mid+1;
                else hi = mid-1;
            } else {
                hi--;
            }
        }
        
        return false;
    }
}
