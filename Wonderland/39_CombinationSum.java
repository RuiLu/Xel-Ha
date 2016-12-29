public class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), 0, candidates, target);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> temp, int start, int[] candidates, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i-1]) continue;
                temp.add(candidates[i]);
                helper(res, temp, i, candidates, target - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
