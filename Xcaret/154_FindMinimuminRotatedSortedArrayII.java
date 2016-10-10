public class Solution {
    /**
     *  Idea -> The basic idea is similar with Find Minimum in Rotated Sorted Array I,
     *          However, we need to check whether nums[mid] is equals to nums[hi].
     *          There are two situations (1) 3,3,3,1,2,3    (2) 3,1,2,3,3,3
     *          These situations both meet nums[mid] == nums[hi], so we need to reduce hi by 1,
     *          which will not affect the result.
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
            
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        
        return nums[lo];
    }
}
