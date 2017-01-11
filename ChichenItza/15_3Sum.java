public class Solution {
    /**
     *  Two pinters.
     *  Time complexity -> O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++) {
            // de-duplicate
            if (i > 0 && nums[i-1] == nums[i]) continue;
            int lo = i+1;
            int hi = nums.length-1;
            while (lo < hi) {
                int sum = nums[i]+nums[lo]+nums[hi];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    // de-duplicate
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                    lo++;
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                    hi--;
                } else if (sum > 0) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        
        return res;
    }
}
