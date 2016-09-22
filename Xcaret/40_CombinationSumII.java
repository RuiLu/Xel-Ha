public class Solution {
    /**
     *  Time complexity -> O(2^n) ?
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        
        Arrays.sort(candidates);
        
        List<Integer> tmp = new ArrayList<>();
        helper(res, tmp, candidates, target, 0);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) res.add(new ArrayList<>(tmp));
        
        
        for (int i = start; i < candidates.length; i++) {
            /* avoid duplicates */
            if (i > start && candidates[i-1] == candidates[i]) continue;
            
            tmp.add(candidates[i]);
            helper(res, tmp, candidates, target - candidates[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
