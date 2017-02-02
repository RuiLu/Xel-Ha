public class Solution {
    /**
     * Idea -> Use dfs and backtracking to calculate all position combinations
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        /* Use Set to avoid dupslicate */
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length <= 1) return new ArrayList<>(res);
        List<Integer> tmp = new ArrayList<>();
        dfs(res, tmp, nums, 0);
        /* convert Set to List */
        return new ArrayList<>(res);
    }
    
    private void dfs(Set<List<Integer>> res, List<Integer> tmp, int[] nums, int idx) {
        /* if subsequence's length is >= 2, add it into result */
        if (tmp.size() >= 2) res.add(new ArrayList<>(tmp));
        
        for (int i = idx; i < nums.length; i++) {
            /* only add element into tmp when tmp is empty or the last element of tmp is <= current element */
            if (tmp.size() == 0 || tmp.get(tmp.size()-1) <= nums[i]) {
                tmp.add(nums[i]);
                dfs(res, tmp, nums, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
