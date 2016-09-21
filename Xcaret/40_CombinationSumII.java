public class Solution {
    /**
     *  Time complexity -> O(2^n) ?
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> tmp, int start) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(tmp));
        else {
            for (int i = start; i < candidates.length; i++) {
                /* The condition here is i > start !! */
                if (i > start && candidates[i-1] == candidates[i]) continue;
                tmp.add(candidates[i]);
                helper(res, candidates, target - candidates[i], tmp, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
