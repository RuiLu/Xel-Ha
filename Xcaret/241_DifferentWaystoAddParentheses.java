public class Solution {
    /**
     *  Idea -> DFS + Divide and Conquer
     *          Once found a operator, divide the input string into two parts, then do dfs, until find single number
     */
    private List<Integer> dfs(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) return map.get(input);
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '+' || curr == '-' || curr == '*') {
                List<Integer> left = dfs(input.substring(0, i), map);
                List<Integer> right = dfs(input.substring(i + 1), map);
                for (int l : left) {
                    for (int r : right) {
                        if (curr == '+') {
                            res.add(l + r);
                        } else if (curr == '-') {
                            res.add(l - r);
                        } else if (curr == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        
        if (res.size() == 0) res.add(Integer.parseInt(input));
        map.put(input, res);
        
        return res;
    }
    
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> map = new HashMap<>();
        return dfs(input, map);
    }
}
