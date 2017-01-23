public class Solution {
    /**
     * Idea -> Backtracking.
     * Time complexity -> O(2^n), for each number in nums, we can choose either add it or not add it into set.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return res;
        dfs(nums, new ArrayList<>(), res, 0);
        return res;
    }
    
    private void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> res, int idx) {
        if (idx == nums.length) return;
        
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            dfs(nums, tmp, res, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
