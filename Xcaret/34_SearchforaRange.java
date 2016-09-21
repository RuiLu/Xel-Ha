public class Solution {
    /**
     *  Using two binary search to locate boundaries 
     *  Time complexity -> O(logn)
     *  Reference -> https://discuss.leetcode.com/topic/5891/clean-iterative-solution-with-two-binary-searches-with-explanation
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        
        if (nums[lo] != target) return res;
        res[0] = lo;
        
        hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2 + 1;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        
        res[1] = hi;
        
        return res;
    }
    
    /**
     *  One pass
     *  Time complexity -> O(n)
     *  Not meeting the requirement
     */
    // public int[] searchRange(int[] nums, int target) {
    //     int[] res = {-1, -1};
    //     if (nums == null || nums.length == 0) return res;
        
    //     int lo = -1;
    //     int hi = -1;
        
    //     for (int i = 0; i < nums.length; i++) {
    //         if (lo == -1 && hi == -1 && nums[i] == target) {
    //             lo = i;
    //         } else if (lo != -1 && nums[i] == target) {
    //             hi = i;
    //         }
    //     }
        
    //     if (lo != -1 && hi != -1) {
    //         res[0] = lo;
    //         res[1] = hi; 
    //     } else if (lo != -1 && hi == -1) {
    //         res[0] = lo;
    //         res[1] = lo;
    //     }
        
    //     return res;
    // }
}
