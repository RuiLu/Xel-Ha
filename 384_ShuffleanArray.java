public class Solution {
    
    /**
     *  Notice -> The implementation of Array is based on pointer, so if we want to new a new array,
     *            we must do 1. new = old.clone(); or 2. new int[], then assign value one by one
     *  The implementation of Shuffle is the way to get a random permutation.
     */
    private int[] nums = null;
    private Random random = null;
    
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;
        
        int[] res = nums.clone();
        for (int i = 1; i < res.length; i++) {
            int r = random.nextInt(i + 1);
            swap(res, i, r);
        }
        return res;
    }
    
    private void swap(int[] res, int i, int r) {
        int tmp = res[i];
        res[i] = res[r];
        res[r] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
