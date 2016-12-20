public class Solution {
    /**
     *  Idea -> If there is a duplicate between 1 and n, then there must be a cycle.
     *          So we can use cycle detection algorithm to solve this problem.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int walker = 0;
        int runner = 0;
        int finder = 0;
        
        while (true) {
            walker = nums[walker];
            runner = nums[nums[runner]];
            if (walker == runner) break;
        }
        
        while (true) {
            if (walker == finder) return walker;
            walker = nums[walker];
            finder = nums[finder];
        }
    }
    
    /**
     *  Idea -> Binary Search
     *          Count the number of elements that are <= the middle element,
     *          then compare.
     *  Time complexity -> O(nlogn)
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) /2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) count++;
            }
            if (count > mid) hi = mid;
            else lo = mid + 1;
        }
        
        return hi;
    }
}
