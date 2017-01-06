public class Solution {
    /**
     *  Idea -> Divide and conquer, actually, it is more like DFS and backtracking.
     *          See comment for details.
     *  Time complexity -> O(n!)
     */ 
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        // first 0 is index in Integer, second 0 is eval in Long, third 0 is prev in Long
        helper(num, res, sb, target, 0, 0, 0);
        return res;
    }
    
    private void helper(String num, List<String> res, StringBuilder sb, int target, int idx, long eval, long prev) {
        // If the index reach num.length and eval is equal to target, add result
        if (idx == num.length()) {
            if (target == eval) {
                res.add(sb.toString());
            }
        } else {
            // get the current length of sb in order for backtracking
            int len = sb.length();
            // Go through all possible combinations for numbers
            for (int i = idx; i < num.length(); i++) {
                // Avoid the situation that get a number from "02"
                if (i != idx && num.charAt(idx) == '0') break;
                
                // To avoid Integer overflow, we use Long here
                long curr = Long.parseLong(num.substring(idx, i+1));
                
                // If the start index is 0, then we can only add number
                // Otherwise, we can add operators before number
                if (idx == 0) {
                    helper(num, res, sb.append(curr), target, i+1, curr, curr);
                    sb.setLength(len);
                } else {
                    helper(num, res, sb.append("+"+curr), target, i+1, eval+curr, curr);
                    sb.setLength(len);
                    helper(num, res, sb.append("-"+curr), target, i+1, eval-curr, -curr);
                    sb.setLength(len);
                    // Trick here, should minus prev before do multiplication
                    helper(num, res, sb.append("*"+curr),
                        target, i+1, eval-prev+prev*curr, prev*curr);
                    sb.setLength(len);
                }
            }
        }
    }
}
