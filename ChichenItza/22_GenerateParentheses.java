public class Solution {
    /**
     *  Idea -> Recursion
     *  Time complexity -> O(2^n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            res.add("");
            return res;
        }
        helper(res, "", n, n);
        return res;
    }
    
    private void helper(List<String> res, String curr, int leftNum, int rightNum) {
        // we have consumed all given parentheses, so add curr into res.
        if (leftNum == 0 && rightNum == 0) {
            res.add(curr);
            return;
        }
        
        // if leftNum > 0, we can always add '(' into curr
        if (leftNum > 0) helper(res, curr+"(", leftNum-1, rightNum);
        // only if rightNum > 0 and rightNum > leftNum, meaning that there are more '(' than ')' in curr,
        // we can add ')' into curr
        if (rightNum > 0 && rightNum > leftNum) helper(res, curr+")", leftNum, rightNum-1);
    }
}
