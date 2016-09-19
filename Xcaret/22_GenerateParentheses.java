public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        if (n < 1) return res;
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (left > n || right > n || left < right) return;
        
        if (sb.length() == n * 2) {
            if (left == right) res.add(sb.toString());
            return;
        }
        
        sb.append("(");
        helper(res, sb, left + 1, right, n);
        sb.deleteCharAt(sb.length() - 1);
        
        sb.append(")");
        helper(res, sb, left, right + 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}
