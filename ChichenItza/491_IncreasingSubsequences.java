public class Solution {
    /**
     * Idea -> Use dfs and backtracking, and use a HashSet to deduplicate.
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length <= 1) return new ArrayList<>(res);
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, res, tmp, 0);
        return new ArrayList<>(res);
    }
    
    private void dfs(int[] nums, Set<List<Integer>> res, List<Integer> tmp, int index) {
        /* if size of tmp is equal to or bigger than 2, we should add it into res*/
        if (tmp.size() >= 2) res.add(new ArrayList<>(tmp));
        
        for (int i = index; i < nums.length; i++) {
            /* if tmp is empty, or last element of tmp is equal to or smaller than the current element, add it into tmp */
            if (tmp.size() == 0 || tmp.get(tmp.size()-1) <= nums[i]) {
                tmp.add(nums[i]);
                dfs(nums, res, tmp, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
