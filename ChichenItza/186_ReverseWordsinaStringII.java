public class Solution {
    /**
     *  Idea -> First, reverse the whole string.
     *          Then reverse each word one by one.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        
        reverse(s, 0, s.length - 1);
        
        int start = 0;
        
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        reverse(s, start, s.length - 1);
    }
    
    private void reverse(char[] s, int lo, int hi) {
        while (lo < hi) {
            char ch = s[lo];
            s[lo] = s[hi];
            s[hi] = ch;
            lo++;
            hi--;
        }
    }
}
