public class Solution {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || n == 0) return res;
        helper(res, new ArrayList<Integer>(), 1, n, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> temp, int start, int target, int k, int n) {
        if (k == 0) {
            if (target == 0) {
                res.add(new ArrayList<Integer>(temp));
            }
        } else {
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                helper(res, temp, i + 1, target - i, k - 1, n);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
}
