public class Solution {
    /**
     *  Idea -> DFS + backtracking.
     *          We should avoid add the number itself into result
     */ 
    private List<List<Integer>> helper(int start, int n, List<Integer> tmp, List<List<Integer>> list) {
        if (n <= 1) {
            if (tmp.size() > 1) list.add(new ArrayList<>(tmp));
            return list;
        }
        
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                tmp.add(i);
                helper(i, n / i, tmp, list);
                tmp.remove(tmp.size() -1);
            }
        }
        
        return list;
    }
    
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList<>();
        if (n <= 1) return list;
        List<Integer> tmp = new ArrayList<>();
        return helper(2, n, tmp, list);
    }
}
