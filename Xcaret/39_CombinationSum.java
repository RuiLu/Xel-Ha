public class Solution {
    /**
     *  First, sort the candidate array
     *  Then, we can avoid duplicates easily
     *  Time complexity -> O(nlogn) + O(n^d), where n is the length of candidates, d is target/(min value from candidates)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> tmp, int start) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > 0 && candidates[i-1] == candidates[i]) continue;
                tmp.add(candidates[i]);
                helper(res, candidates, target - candidates[i], tmp, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

