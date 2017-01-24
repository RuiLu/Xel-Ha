public class Solution {
    /**
     * Idea -> Find a pattern, for example
     *         n = 0 -> 0
     *         n = 1 -> 0  ,   1
     *         n = 2 -> 00 ,  01,  11,  10
     *         n = 3 -> 000, 001, 011, 010, 110, 111, 101, 100
     * Time complexity -> O(2^n)
     * Space complexity -> O(1)
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 0) return res;
        
        res.add(0);
        if (n == 0) return res;
        res.add(1);
        if (n == 1) return res;
        
        for (int i = 2; i <= n; i++) {
            int size = res.size();
            for (int j = size-1; j >= 0; j--) {
                res.add((1<<(i-1))+res.get(j));
            } 
        }
        
        return res;
    }
}
