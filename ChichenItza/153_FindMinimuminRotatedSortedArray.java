public class Solution {
    /**
     *  Idea -> Binary search
     *          Consider the following three situations:
     *          1. 0 1 2 4 5 6 7
     *          2. 6 7 0 1 2 4 5
     *          3. 4 5 6 7 0 1 2
     *          Then we find regulation easily.
     *  Time complexity -> O(logn)
     *  Space complexity -> O(1)
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        
        return nums[hi];
    }
}
