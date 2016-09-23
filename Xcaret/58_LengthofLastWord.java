public class Solution {
    /**
     *  Time complexity -> O(n)
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        
        int len = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') return len;
            len++;
        }
        
        return len;
    }
    
    /**
     *  Using method
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIdx = s.lastIndexOf(' ') + 1;
        return s.length() - lastIdx;
    }
}
