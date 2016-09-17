public class Solution {
    /**
     *  Dynamic Programming
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int len = s.length();
        int[] dp = new int[len + 1];
        char[] sca = s.toCharArray();
        
        for (int i = 0; i <= len; i++) dp[i] = i - 1;
        
        for (int i = 0; i < len; i++) {
            /* checking palindrome for odd length */
            for (int j = 0; i - j >= 0 && i + j < len && sca[i - j] == sca[i + j]; j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i - j] + 1);
            }
            
            /* checking palindrome for even length */
            for (int j = 1; i - j + 1 >= 0 && i + j < len && sca[i - j + 1] == sca[i + j]; j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i - j + 1] + 1);
            }
        }
        
        return dp[len];
    }
    
    /**
     *  Backtracking -> get all possible answers, and get the smallest one
     *  Time limited and memory limited exceeded
     */
    // public int minCut(String s) {
    //     if (s == null || s.length() == 0) return 0;
    //     List<List<String>> lists = new ArrayList<>();
    //     int min = Integer.MAX_VALUE;
        
    //     helper(lists, new ArrayList<>(), s);
        
    //     for (List<String> list : lists) {
    //         min = Math.min(list.size(), min);
    //     }
        
    //     return min == Integer.MAX_VALUE ? 0 : min - 1;
    // }
    
    // private void helper(List<List<String>> lists, List<String> temp, String s) {
    //     if (s.equals("")) {
    //         lists.add(new ArrayList<>(temp));
    //         return;
    //     }
        
    //     for (int i = 1; i <= s.length(); i++) {
    //         String next = s.substring(0, i);
    //         if (isPalindrome(next)) {
    //             temp.add(next);
    //             helper(lists, temp, s.substring(i));
    //             temp.remove(temp.size() - 1);
    //         }
    //     }
    // }
    
    // private boolean isPalindrome(String str) {
    //     int start = 0;
    //     int end = str.length() - 1;
        
    //     while (start < end) {
    //         if (str.charAt(start++) != str.charAt(end--)) return false;
    //     }
        
    //     return true;
    // }
}
