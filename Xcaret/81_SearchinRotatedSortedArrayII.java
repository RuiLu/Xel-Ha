public class Solution {
    /**
     *  Except for the binary search, we should also compare nums[mid] to nums[hi]
     *  Time complexity -> O(logn)
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            if (nums[mid] > nums[hi]) {
                if (target > nums[mid] || target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            } else if (nums[mid] == nums[hi]) {
                hi--;
            } else {
                if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        
        return false;
    }
}
