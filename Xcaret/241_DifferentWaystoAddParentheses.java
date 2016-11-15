public class Solution {
    /**
     *  Idea -> DFS + Divide and Conquer
     *          Once found a operator, divide the input string into two parts, then do dfs, until find single number
     *  Time complexity -> O(2^n), exponential order
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) return res;
        Map<String, List<Integer>> map = new HashMap<>();
        return helper(input, map);
    }
    
    private List<Integer> helper(String input, Map<String, List<Integer>> map) {
        List<Integer> res = new ArrayList<>();
        
        if (map.containsKey(input)) return map.get(input);
        
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            
            if (curr == '+' || curr == '-' || curr == '*') {
                List<Integer> left = helper(input.substring(0, i), map);
                List<Integer> right = helper(input.substring(i + 1), map);
                
                for (int l : left) {
                    for (int r : right) {
                        switch(curr) {
                            case '+':
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        
        if (res.size() == 0) res.add(Integer.parseInt(input));
        
        return res;
    }
}
