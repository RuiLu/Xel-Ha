public class Solution {
    /**
     *  Time complexity -> O(n^3)
     * 
     *  There is one solution for solving general kSum problem, by reducing kSum to 2Sum
     *  Ref -> https://discuss.leetcode.com/topic/46339/my-solution-generalized-for-ksums-in-java
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums == null || nums.length < 4) return res;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int lo = j + 1;
                int hi = nums.length - 1;
                
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        
                        lo++;
                        hi--;
                    } else if (sum > target) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        
        return res;
    }

}

