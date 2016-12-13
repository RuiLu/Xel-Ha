public class Solution {
    /**
     *  Idea -> KMP
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int[] table = getTable(s + "#" + new StringBuilder(s).reverse().toString());
        return new StringBuilder(s.substring(table[table.length-1])).reverse().toString() + s;
    }
    
    private int[] getTable(String s) {
        int len = s.length();
        int[] table = new int[len+1];
        int i = 0;
        int j = -1;
        table[i] = j;
        
        while (i < len) {
            while (j >= 0 && s.charAt(i) != s.charAt(j)) j = table[j];
            i++;
            j++;
            table[i] = j;
        }
        
        return table;
    }
}
