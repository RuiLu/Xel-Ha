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
        helper(res, sb, num, target, 0, 0, 0);
        return res;
    }
    
    /**
     *  Trick here is to keep the "prev", which is useful when meeting '*'
     *  for example, when calculating 1+2+3*4, 1. 1+2+3 -> 2. 1+2+3-3 -> 3. 1+2+3*4
     *  @eval: the current caculated value.
     *  @prev: the caculated value from previous step.
     */
    private void helper(List<String> res, StringBuilder sb, String num, int target, int idx, long eval, long prev) {
        if (idx == num.length()) {
            if (eval == target) {
                res.add(sb.toString());
            }
        } else {
            /* Get the current length of StringBuilder, in order to do backtracking */
            int len = sb.length();
            
            for (int i = idx; i < num.length(); i++) {
                /* Avoid the situation that the number starts with 0, like "01" */
                if (i != idx && num.charAt(idx) == '0') break;
                
                long curr = Long.parseLong(num.substring(idx, i+1));
                
                /* If it is the first round, obviously we cannot do any operation. */
                if (idx == 0) {
                    helper(res, sb.append(curr), num, target, i+1, curr, curr);
                    sb.setLength(len);
                } else {
                    helper(res, sb.append("+"+curr), num, target, i+1, eval+curr, curr);
                    sb.setLength(len);
                    helper(res, sb.append("-"+curr), num, target, i+1, eval-curr, -curr);
                    sb.setLength(len);
                    /* Trick */
                    helper(res, sb.append("*"+curr), num, target, i+1, eval-prev+prev*curr, prev*curr);
                    sb.setLength(len);
                }
            }
        }
    }
}
