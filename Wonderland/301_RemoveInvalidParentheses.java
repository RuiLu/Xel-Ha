public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution
     *  Time complexity -> might be O(nk), where k is the size of result
     */ 
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(s, res, 0, new char[]{'(', ')'});
        return res;
    }
    
    private void remove(String s, List<String> res, int prevJ, char[] par) {
        int stack = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            
            for (int j = prevJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == prevJ || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1), res, j, par);
                }
            }
            return;
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') remove(reversed, res, 0, new char[]{')', '('});
        else res.add(reversed);
    }
}
