public class Solution {
    /**
     *  Use index ~ 2ms
     *  Time complxity -> O(n), where n is the length of s
     *  Also can know that array's operations is faster than string's operations
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.length() == 0) return true;
        
        int prevIdx = 0;
        char[] sca = s.toCharArray();
        
        for (int i = 0; i < sca.length; i++) {
            int currIdx = t.indexOf(sca[i], prevIdx);
            if (currIdx == -1 || t.length() - currIdx < sca.length - i) return false;
            prevIdx = currIdx + 1;
        }
        
        return true;
    }

    /**
     *  Greedy thought ~ 56ms
     *  Time complxity -> O(m), where n is the length of t
     */ 
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.length() == 0) return true;
        
        int sIdx = 0;
        
        for (int tIdx = 0; tIdx < t.length(); tIdx++) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) sIdx++;
            if (sIdx == s.length()) return true;
        }
        
        return false;
    }    
}
