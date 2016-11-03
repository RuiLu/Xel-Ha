public class Solution {
    /**
     *  Idea -> DFS + Divide and Conquer
     *          Once found a operator, divide the input string into two parts, then do dfs, until find single number
     */
    private List<Integer> dfs(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) return map.get(input);
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == '+' || curr == '-' || curr == '*') {
                // divide
                List<Integer> left = dfs(input.substring(0, i), map);
                List<Integer> right = dfs(input.substring(i + 1), map);
                
                // conquer
                for (int l : left) {
                    for (int r : right) {
                        if (curr == '+') list.add(l + r);
                        else if (curr == '-') list.add(l - r);
                        else if (curr == '*') list.add(l * r);
                    }
                }
            }
        }
        
        if (list.size() == 0) list.add(Integer.parseInt(input));
        map.put(input, list);
        
        return list;
    }
    
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> map = new HashMap<>();
        return dfs(input, map);
    }
}
