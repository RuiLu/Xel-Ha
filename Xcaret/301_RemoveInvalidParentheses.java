public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution
     *  Time complexity -> O(nk), where k is the size of result
     */
    private static void helper(String s, List<String> res, int lastI, int lastJ, char[] par) {
        int stack = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            
            /* The number of ')' is more than '(' */
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    String next = s.substring(0, j) + s.substring(j + 1);
                    helper(next, res, i, j, par);
                }
            }
            return;
        }
        
        /* Reverse the original string and check again. In order to process "(()(()" */
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            helper(reversed, res, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }
    
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add(s);
            return res;
        }
        helper(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }
}
