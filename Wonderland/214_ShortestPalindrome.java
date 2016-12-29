public class Solution {
    
    /*
     * 1. Naive solution: Brute force, TLE
     */
    // public String shortestPalindrome(String s) {
    //     if (s == null || s.length() == 0) return "";
    //     if (s.length() == 1) return s;
        
    //     for (int i = s.length(); i > 0; i--) {
    //         String curr = s.substring(0, i);
    //         if (isPalindrome(curr)) {
    //             return reverseString(s.substring(i)) + s;
    //         }
    //     }
    //     return reverseString(s.substring(1)) + s;
    // }
    
    // private boolean isPalindrome(String string) {
    //     int start = 0, end = string.length() - 1;
    //     while (start <= end) {
    //         if (string.charAt(start++) != string.charAt(end--)) return false;
    //     }
    //     return true;
    // }
    
    // private String reverseString(String string) {
    //     StringBuilder sb = new StringBuilder(string);
    //     return sb.reverse().toString();
    // }
    
    /*
     * 2. Recursive
     */
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) j++;
        }
        if (s.length() == j) return s;
        String suffix = s.substring(j);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
    
    /*
     * 3. Trick + KMP,  s + # + reverse(s)
     */
     public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        return new StringBuilder(s.substring(table[table.length-1])).reverse().toString() + s;
     }
     
     private int[] getTable(String s) {
         int i = 0, j = -1;
         int[] table = new int[s.length() + 1];
         table[i] = j;
         while (i < s.length()) {
             while (j >= 0 && s.charAt(i) != s.charAt(j)) j = table[j];
             i++;
             j++;
             table[i] = j;
         }
         return table;
     } 
}
