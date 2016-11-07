public class Solution {
    /**
     *  Idea -> Divide and Conquer
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        helper(res, new StringBuilder(), num, target, 0, 0, 0);
        return res;
    }

    /**
     * the trick here is to keep the "prev", which is useful when meeting '*'
     * for example, when calculating 1+2+3*4, 1. 1+2+3 -> 2. 1+2+3-3 -> 3. 1+2+3*4
     */
    private static void helper(List<String> res, StringBuilder sb, String num, int target, int idx, long eval, long prev) {
        if (idx == num.length()) {
            if (eval == target) {
                res.add(sb.toString());
            }
        } else {
            for (int i = idx; i < num.length(); i++) {
                if (i != idx && num.charAt(idx) == '0') break;
                long curr = Long.parseLong(num.substring(idx, i + 1));
                int len = sb.length();  // record for backtracking
                
                if (idx == 0) {
                    helper(res, sb.append(curr), num, target, i + 1, curr, curr);
                    sb.setLength(len);
                } else {
                    helper(res, sb.append("+" + curr), num, target, i + 1, eval + curr, curr);
                    sb.setLength(len);
                    helper(res, sb.append("-" + curr), num, target, i + 1, eval - curr, -curr);
                    sb.setLength(len);
                    helper(res, sb.append("*" + curr), num, target, i + 1, eval - prev + prev * curr, prev * curr);
                    sb.setLength(len);
                }
            }
        }
    }
}
