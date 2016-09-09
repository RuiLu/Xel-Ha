public class Solution {
    /**
     *  DFS
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 1) return res;
        
        for (int i = 1; i <= (n >= 9 ? 9 : n); i++) {
            helper(res, i, n);
        }
        
        return res;
    }
    
    private boolean helper(List<Integer> res, int curr, int limit) {
        if (curr > limit) return false;
        
        res.add(curr);
        
        for (int i = 0; i <= 9; i++) {
            if (!helper(res, curr * 10 + i, limit)) break;
        }
        
        return true;
    }
}
