public class Solution {
    /**
     *  Idea -> KMP + "s + # + reverse(s)"
     *  Reference -> https://discuss.leetcode.com/topic/27261/clean-kmp-solution-with-super-detailed-explanation/2
     *  Time complexity -> O(n)
     */
    private int[] getTable(String s) {
        int[] table = new int[s.length()+1];
        int i = 0;
        int j = -1;
        table[i] = j;
        
        while (i < s.length()) {
            while (j >= 0 && s.charAt(i) != s.charAt(j)) j = table[j];
            i++;
            j++;
            table[i] = j;
        }
        
        return table;
    }
    
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int[] table = getTable(s + "#" + new StringBuilder(s).reverse().toString());
        return new StringBuilder(s.substring(table[table.length-1])).reverse().toString() + s;
    }
    
    /**
     *  Idea -> recursive
     *  Time complexity -> O(n^2)
     */
    // public String shortestPalindrome(String s) {
    //     int j = 0;
    //     for (int i = s.length() - 1; i >= 0; i--) {
    //         if (s.charAt(j) == s.charAt(i)) j++;
    //     }
    //     if (s.length() == j) return s;
    //     String suffix = s.substring(j);
    //     return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    // }
}
