public class Solution {
    /**
     *  Idea -> Binary search
     *  Time complexity -> O(nlogn)
     *  Space complexity -> O(1)
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int count = 0;
            
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) count++;
            }
            
            if (count > mid) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return lo;
    }
}
