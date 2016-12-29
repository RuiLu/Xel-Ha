public class Solution {
    /**
     *  DFS -> make sure that the amount of '(' that is being used is always equal or bigger than that of ')'
     * 
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        char[] items = new char[n * 2];
        dfs(res, items, 0, n, n);
        return res;
    }
    
    private void dfs(List<String> res, char[] items, int index, int leftNum, int rightNum) {
        if (index == items.length) {
            res.add(new String(items));
            return;
        }
        
        if (leftNum > 0 && leftNum <= rightNum) {
            items[index] = '(';
            dfs(res, items, index + 1, leftNum - 1, rightNum);
        }
        
        if (rightNum > 0) {
            items[index] = ')';
            dfs(res, items, index + 1, leftNum, rightNum - 1);
        }
    }
    
}
