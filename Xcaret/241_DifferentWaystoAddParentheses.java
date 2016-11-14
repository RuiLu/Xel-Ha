public class Solution {
    /**
     *  Idea -> DFS + Divide and Conquer
     *          Once found a operator, divide the input string into two parts, then do dfs, until find single number
     *  Time complexity -> O(2^n), exponential order
     */
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) return new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        return helper(input, map);
    }
    
    private List<Integer> helper(String s, Map<String, List<Integer>> map) {
        if (map.containsKey(s)) return map.get(s);
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '+' || curr == '-' || curr == '*') {
                List<Integer> left = helper(s.substring(0, i), map);
                List<Integer> right = helper(s.substring(i + 1), map);
                
                for (int l : left) {
                    for (int r : right) {
                        if (curr == '+') res.add(l + r);
                        else if (curr == '-') res.add(l - r);
                        else if (curr == '*') res.add(l * r);
                    }
                }
            }
        }
        
        /* Means that string only contains digit(s) */
        if (res.size() == 0) res.add(Integer.parseInt(s));
        
        map.put(s, res);
        return res;
    }
}
