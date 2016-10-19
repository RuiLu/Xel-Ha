public class Solution {
    /**
     *  Idea -> backtracking
     *  Time complexity -> O(2^k)
     *  Space complexity -> O(n)
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) return res;
        
        // if the n is smaller than the accumulated sum, then return res directly
        int accumulation = 0;
        for (int i = 1; i <= k; i++) accumulation += i;
        if (n < accumulation) return res;
        
        List<Integer> tmp = new ArrayList<>();
        helper(res, tmp, k, n, 1);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> tmp, int times, int target, int start) {
        if (times < 0) return;
        if (times == 0) {
            if (target == 0) res.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (i <= target) {
                tmp.add(i);
                helper(res, tmp, times - 1, target - i, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
