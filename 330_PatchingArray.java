public class Solution {
    /**
     *  So tricky.
     *  Reference -> https://discuss.leetcode.com/topic/35494/solution-explanation
     */
    public int minPatches(int[] nums, int n) {
        /* the "miss" should be long, cos int might be overflowed */
        long miss = 1;
        int added = 0;
        int i = 0;
        
        while (miss <= n) {
            if (i < nums.length && miss >= Long.valueOf(nums[i])) {
                miss += Long.valueOf(nums[i++]);
            } else {
                miss += miss;
                added++;
            }
        }
        
        return added;
    }
}
