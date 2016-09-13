public class Solution {
    /**
     *  Reservoir sampling
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    private Random rand;
    private int[] nums;
    
    public Solution(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && rand.nextInt(++count) == 0) result = i;
        }
        return result;
    }
    
    
    /**
     *  Naive way, which takes a lot of time, but will not introduce Memory Limit Exceeded
     */
    // private Random rand;
    // private int[] nums;

    // public Solution(int[] nums) {
    //     rand = new Random();
    //     this.nums = nums;
    // }
    
    // public int pick(int target) {
    //     List<Integer> list = new ArrayList<>();
    //     int size = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == target) {
    //             list.add(i);
    //             size++;
    //         }
    //     }
    //     return list.get(rand.nextInt(size));
    // }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
