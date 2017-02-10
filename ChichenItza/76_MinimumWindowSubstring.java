public class Solution {
    /**
     * Idea -> Two pointers + Map
     * Time complexity -> O(n)
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        
        int begin = 0;
        int end = 0;
        int counter = 0;
        int minIndex = 0;
        int minLen = Integer.MAX_VALUE;
        int[] map = new int[256];
        
        for (char ch : t.toCharArray()) {
            map[ch]++;
            counter++;
        }
        
        while (end < s.length()) {
            char ch = s.charAt(end++);
            
            /* when we meet a valid character in t */
            if (map[ch] > 0) counter--;
            
            /* minus the meeting character by one, and move 'end' right */
            map[ch]--;
            
            /* found all characters from t */
            while (counter == 0) {
                if (end-begin < minLen) {
                    minLen = end-begin;
                    minIndex = begin;
                }
                
                if (map[s.charAt(begin)] == 0) {
                    counter++;
                }
                
                map[s.charAt(begin++)]++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minIndex, minIndex+minLen);
    }
}
