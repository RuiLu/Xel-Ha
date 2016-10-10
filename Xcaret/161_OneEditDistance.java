public class Solution {
    /**
     *  One edit distance: 1. add one character; 2. delete one character; 3. change one character
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (Math.abs(sLen - tLen) > 1) return false;
        if (sLen < tLen) return isOneDel(t, s);
        else if (sLen > tLen) return isOneDel(s, t);
        else return isOneModified(s, t);
    }
    
    /**
     *  If we find one different character, we can simply compare the following substrings
     */
    private boolean isOneDel(String s, String t) {
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
                return s.substring(i + 1).equals(t.substring(j));
            }
        }
        return true;
    }
    
    /**
     *  We can count the number of different characters
     */
    private boolean isOneModified(String s, String t) {
        int diffCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) diffCount++;
        }
        return diffCount == 1;
    }
}
