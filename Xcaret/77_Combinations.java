public class Solution {
    /**
     *  Backtracking
     *  Time complexity -> O(2^n)
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) return res;
        helper(res, n, k, new ArrayList<>(), 1);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int n, int k, List<Integer> tmp, int start) {
        if (k == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            helper(res, n, k, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
