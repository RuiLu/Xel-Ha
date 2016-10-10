public class Solution {
    /**
     *  Binary search
     *  Time complexity -> O(logn)
     *  Space complexity -> O(1)
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        
        return nums[lo];
    }
}
