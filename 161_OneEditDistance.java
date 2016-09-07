public class Solution {
    /**
     *  An edit between two strings is one of the following changes.
     *        
     *       a. Add a character
     *       b. Delete a character
     *       c. Change a character
     *
     *  So, the sequences of characters from both strings are the same
     * 
     *  Time complexity -> O(n)
     */
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (Math.abs(sLen - tLen) > 1) return false;
        if (sLen < tLen) return isOneEditDistance(t, s);
        else if (sLen > tLen) return isOneDel(s, t);
        else return isOneModified(s, t);
    }
    
    private boolean isOneDel(String s, String t) {
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) return s.substring(i + 1).equals(t.substring(j));
        }
        return true;
    }
    
    private boolean isOneModified(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) != t.charAt(i)) diff++;
        return diff == 1;
    }
}
