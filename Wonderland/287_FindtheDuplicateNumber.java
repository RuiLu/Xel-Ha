public class Solution {
    /**
     *  Same idea as LinkedList Cycle II
     *  Reference -> https://discuss.leetcode.com/topic/25913/my-easy-understood-solution-with-o-n-time-and-o-1-space-without-modifying-the-array-with-clear-explanation
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = 0;
        
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
    
    /**
     *  Binary Search
     *  Time complexity -> O(nlogn)
     */
    public int findDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) count++;
            }
            if (count > mid) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return lo;
    }
    
    /**
     *  So naive...brute force
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(1)
     */
    // public int findDuplicate(int[] nums) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[i] == nums[j]) return nums[i];
    //         }
    //     }
    //     return -1;
    // }
}
