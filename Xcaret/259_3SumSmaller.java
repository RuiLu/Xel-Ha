public class Solution {
    /**
     *  Idea -> Two pointers, and this problem allows duplicates
     *  Time complexity -> O(n^2)
     */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) return 0;
        
        Arrays.sort(nums);
        int num = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum >= target) {
                    hi--;
                } else {
                    /* tricky part */
                    num += hi - lo;
                    lo++;
                }
            }
        }
        
        return num;
    }
}
