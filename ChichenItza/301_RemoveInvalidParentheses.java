public class Solution {
    /**
     *  Idea -> 1. Use a stack to determine whether the current s is valid,
     *             If meet '(', add 1 to stack; if meet ')', subtract 1 to stack. 
     *             If stack >= 0, valid, otherwice, invalid.
     *          2. When removing the invalid ')', we need to avoid duplicate.
     *             If meet invalid ')' in continuous ')', only remove the first ')'.
     *          3. If s == "(()(()", how to deal with it? 
     *             We can do the same thing from right to left.
     *  Time complexity -> roughly O(nm), where n is the length of string, m is the number of total recursive calls.
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(result, s, 0, 0, new char[]{'(', ')'});
        return result;
    }
    
    private void remove(List<String> res, String s, int lastI, int lastJ, char[] par) {
        int stack = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j-1) != par[1])) {
                    remove(res, s.substring(0, j) + s.substring(j+1), i, j, par);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(res, reverse, 0, 0, new char[]{')', '('}); 
        } else {
            res.add(reverse);
        }
    }
}
