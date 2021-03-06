public class Solution {
    /**
     *  Backtracking
     *  Time complexity -> O(n!) -> n * (n-1) * (n-2) * ... * 1
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> tmp = new ArrayList<>();
        helper(res, tmp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> tmp, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (isPalindrome(sub)) {
                tmp.add(sub);
                helper(res, tmp, s, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String string) {
        int lo = 0;
        int hi = string.length() - 1;
        while (lo < hi) {
            if (string.charAt(lo++) != string.charAt(hi--)) return false;
        }
        return true;
    }
    
    /**
     *  Dynamic Programming
     *  Time complexity -> O(n^2)
     */
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return new ArrayList<List<String>>();
        int len = s.length();
        List<List<String>>[] results = new List[len+1];
        results[0] = new ArrayList<List<String>>();
        results[0].add(new ArrayList<>());
        
        boolean[][] dp = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            results[i+1] = new ArrayList<List<String>>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i - left <= 1 || dp[left+1][i-1])) {
                    dp[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> prev : results[left]) {
                        List<String> curr = new ArrayList<>(prev);
                        curr.add(str);
                        results[i+1].add(curr);
                    }
                }
            }
        }
        
        return results[len];
    }
}
