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

    /**
     *  Iteration
     *  Reference -> https://discuss.leetcode.com/topic/55184/java-o-n-time-o-1-space-iterative-solution-130ms
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 1) return res;
        
        int curr = 1;
        
        for (int i = 1; i <= n; i++) {
            res.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) curr /= 10;
                curr = curr / 10 + 1;
            }
        }
        
        return res;
    }
}
