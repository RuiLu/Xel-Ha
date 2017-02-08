public class Solution {
    /**
     * Idea -> Backtracking
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) return res;
        List<Integer> tmp = new ArrayList<>();
        dfs(res, tmp, n, 2);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int n, int start) {
        for (int i = start; i < n; i++) {
            if (n%i == 0) {
                tmp.add(i);
                
                /* make sure that the latter element is >= the current element */
                if (n/i >= i) {
                    tmp.add(n/i);
                    res.add(new ArrayList<>(tmp));
                    tmp.remove(tmp.size()-1);
                }
                
                dfs(res, tmp, n/i, i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
