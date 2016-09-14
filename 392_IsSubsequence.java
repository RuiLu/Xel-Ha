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
     *  Greedy thought ~ 80ms
     *  Time complxity -> O(m), where n is the length of t
     */ 
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int idx = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(idx) == t.charAt(i)) idx++;
            if (idx == s.length()) return true;
        }
        return false;
    }
}
