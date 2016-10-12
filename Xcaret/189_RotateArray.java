public class Solution {
    /**
     *  Second
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        
        int len = nums.length;
        k %= len;
        
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
    
    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo++;
            hi--;
        }
    }
    
    /**
     *  First -> using a auxiliary array
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        
        int len = nums.length;
        k %= len;
        
        if (k == 0) return;
        
        int[] tmp = new int[len];
        
        for (int i = 0; i < len; i++) {
            tmp[(i+k)%len] = nums[i];
        }
        
        for (int i = 0; i < len; i++) {
            nums[i] = tmp[i];   
        }
    }
    
}
