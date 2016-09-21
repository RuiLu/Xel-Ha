public class Solution {
    /**
     *  Binary search
     *  Time complexity -> O(logn)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                if (nums[lo] <= nums[mid] && nums[lo] > target) lo = mid + 1;
                else hi = mid - 1;
            } else {
                if (nums[hi] >= nums[mid] && nums[hi] < target) hi = mid - 1;
                else lo = mid + 1;
            }
        }
        
        return -1;
    }
}
