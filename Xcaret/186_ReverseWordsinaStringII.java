public class Solution {
    /**
     *  Idea -> 1. reverse the whole string
     *          2. reverse each word one by one
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        
        int begin = 0;
        int end = s.length - 1;
        
        swap(s, begin, end);
        
        int prev = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                swap(s, prev, i - 1);
                prev = i + 1;
            }
        }
        swap(s, prev, s.length - 1);
    }
    
    private void swap(char[] s, int lo, int hi) {
        while (lo < hi) {
            char tmp = s[lo];
            s[lo] = s[hi];
            s[hi] = tmp;
            lo++;
            hi--;
        }
    }
}
