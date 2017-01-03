public class Solution {
    /**
     *  Idea -> DFS + Backtracking
     *  Time complexity -> O(n!) -> O(n) * O(n-1) * O(n-2) * ... * O(1).
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> tmp = new ArrayList<>();
        dfs(s, res, tmp);
        return res;
    }
    
    private void dfs(String s, List<List<String>> res, List<String> tmp) {
        if (s.equals("")) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (isPalindrome(substring)) {
                tmp.add(substring);
                dfs(s.substring(i), res, tmp);
                tmp.remove(tmp.size()-1);
            }   
        }
    }
    
    private boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }
}
