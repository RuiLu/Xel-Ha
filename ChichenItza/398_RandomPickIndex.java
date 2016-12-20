public class Solution {
    /**
     *  Idea -> Reservoir Sampling
     *          * If (random.nextInt(count) == 0) res = i,
     *          where count is the occurrence number of target, res is the result, i is the current index.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    private int[] nums; 
    private Random rand;
     
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
                if (rand.nextInt(count) == 0) res = i;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
