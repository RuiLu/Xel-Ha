public class Solution {
    /**
     *  Time complexity -> O(n^2)
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        
        int res = 0;
        int gap = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int lo = i + 1;
            int hi = nums.length - 1;
            
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                
                if (sum == target) {
                    return sum;    
                } else {
                    if (Math.abs(sum - target) < gap) {
                        res = sum;
                        gap = Math.abs(sum - target);
                    }
                    
                    if (sum > target) hi--;
                    else lo++;
                }
            }
        }
        
        return res;
    }
}
