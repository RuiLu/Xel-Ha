public class Solution {
    /**
     *  Idea -> Sliding window
     *          Record the count of the character that appears most times in the sliding window.
     *          We use start and end pointers to maintain len(window) - maxCharCount <= k.
     *          If not satisfying the equation, we need to update the window.
     *  Time complexity -> O(n)
     *  Space complexity -> O(26)
     */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        
        int end = 0;
        int start = 0;
        int maxCharCount = 0;
        int[] counts = new int[26];
        int res = 0;
        char maxChar = s.charAt(0);;
        
        for (; end < s.length(); end++) {
            char curr = s.charAt(end);
            
            counts[curr-'A']++;
            if (maxCharCount < counts[curr-'A']) {
                maxCharCount = counts[curr-'A'];
                maxChar = curr;
            }
            
            while (end - start + 1 - maxCharCount > k) {
                char startChar = s.charAt(start++);
                counts[startChar-'A']--;
                if (startChar == maxChar) maxCharCount--;
                for (int i = 0; i < 26; i++) {
                    if (maxCharCount < counts[i]) {
                        maxCharCount = counts[i];
                        maxChar = (char)(i + 'A');
                    }
                }
            }
            
            res = Math.max(res, end - start + 1);
        }
        
        return res;
    }
}
