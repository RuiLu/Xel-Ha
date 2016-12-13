public class Solution {
    /**
     *  Idea -> 1. Sort the original array
     *          2. Maintain first and second pointers
     *          3. Find the answers
     *          4. Pay attention to de-duplicate.
     *  Time complexity -> O(n^3)
     *  Space complexity -> O(1)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 3) return res;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j <= nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int lo = j + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    if (nums[i] + nums[j] + nums[lo] + nums[hi] == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[lo]);
                        tmp.add(nums[hi]);
                        res.add(tmp);
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        hi--;
                    } else if (nums[i] + nums[j] + nums[lo] + nums[hi] < target) {
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        lo++;
                    } else {
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        hi--;
                    }
                }
            }
        }
        
        return res;
    }
}
