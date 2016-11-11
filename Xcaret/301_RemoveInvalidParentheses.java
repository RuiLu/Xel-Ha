public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution
     *  Time complexity -> O(nk), where k is the size of result
     */
    public static List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            list.add("");
            return list;
        }
        helper(s, list, 0, new char[]{'(', ')'});
        return list;
    }
    
    private static void helper(String s, List<String> list, int lastJ, char[] par) {
        int stack = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    String next = s.substring(0, j) + s.substring(j + 1);
                    helper(next, list, j, par);
                }
            }
            
            return;
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            helper(reversed, list, 0, new char[]{')', '('});
        } else {
            list.add(reversed);
        }
    }
}
