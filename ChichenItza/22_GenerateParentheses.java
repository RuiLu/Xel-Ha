public class Solution {
    /**
     *  Idea -> Recursion
     *  Time complexity -> O(2^n)
     */
    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();
       if (n <= 0) return res;
       dfs(n, n, res, "");
       return res;
    }
    
    private void dfs(int leftNum, int rightNum, List<String> res, String str) {
        /* all left and right parentheses are used up */
        if (leftNum == 0 && rightNum == 0) {
            res.add(str);
            return;
        }
        
        /* if there are available '(', then append '(' to str */
        if (leftNum > 0) dfs(leftNum-1, rightNum, res, str+"(");
        /* if there are available ')', and the remaining ')' is more then the remaining '(',
         * then append ')' to str */
        if (rightNum > 0 && rightNum > leftNum) dfs(leftNum, rightNum-1, res, str+")");
    }
}
