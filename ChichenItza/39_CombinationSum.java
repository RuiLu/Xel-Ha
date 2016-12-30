public class Solution {
    /**
     *  Idea -> First sort, then DFS + backtracking
     *  Time complexity -> O(nlogn) + O(n^d), where d is (target / (minimal value from candidates))
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return rst;
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, rst, tmp, target, 0);
        return rst;
    }
    
    private void helper(int[] candidates, List<List<Integer>> rst, List<Integer> tmp, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            rst.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            helper(candidates, rst, tmp, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
