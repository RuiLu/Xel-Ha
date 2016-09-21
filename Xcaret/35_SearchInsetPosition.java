public class Solution {
    /**
     *  Binary Search
     *  Time complexity -> O(logn)
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return lo;
    }
    
    /**
     *  Time complexity -> O(n)
     */
    // public int searchInsert(int[] nums, int target) {
    //     if (nums == null || nums.length == 0) return 0;
        
    //     int i = 0;
    //     for (; i < nums.length; i++) {
    //         if (nums[i] >= target) return i;
    //     }
        
    //     return i;
    // }
}
