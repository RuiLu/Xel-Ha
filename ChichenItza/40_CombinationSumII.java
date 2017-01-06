public class Solution {
    /**
     *  Idea -> dfs + backtracking.
     *          While doing dfs: 1. We need to avoid duplicates;
     *                           2. We should break the for-loop while not satisfying the condition asap to save time.
     *  Time complexity -> O(nlogn) + O(2^n)
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        List<Integer> tmp = new ArrayList<>();
        /* Sort the collection of numbers first */
        Arrays.sort(candidates);
        /* Do dfs, maintain the current starting index and current sum */
        dfs(candidates, res, tmp, target, 0, 0);
        return res;
    }
    
    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> tmp, int target, int idx, int eval) {
        if (eval == target) {
            res.add(new ArrayList<>(tmp));
        } else if (eval < target) {
            for (int i = idx; i < candidates.length; i++) {
                /* Avoid duplicate */
                if (i > idx && candidates[i] == candidates[i-1]) continue;
                /* Avoid to do useless work, break the for-loop asap */
                if (eval+candidates[i] > target) break;
                tmp.add(candidates[i]);
                dfs(candidates, res, tmp, target, i+1, eval+candidates[i]);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
