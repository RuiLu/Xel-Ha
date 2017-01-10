public class Solution {
    /**
     *  Idea -> Backtraking and recursion
     *  Time complexity -> O(2^k)
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0) return res;
        List<Integer> tmp = new ArrayList<>();
        backtracking(res, tmp, 1, 9, k, n, 0);
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, List<Integer> tmp, int start, int end, int k, int n, int eval) {
        if (k < 0) return;
        if (eval == n) {
            if (k == 0) res.add(new ArrayList<>(tmp));
        } else if (eval < n) {
            for (int i = start; i <= end; i++) {
                if (eval+i > n) break;
                tmp.add(i);
                backtracking(res, tmp, i+1, end, k-1, n, eval+i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
