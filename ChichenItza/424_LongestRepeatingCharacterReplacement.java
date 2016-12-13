public class Solution {
    /**
     *  Idea -> Maintain a sliding window.
     *          The length of window should satisfy - end-start+1-maxCharCount <= k.
     *          In the meantime, maintain a maxChar and its maxCharCount in the window.
     */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        
        int start = 0;
        int end = 0;
        char maxChar = s.charAt(0);
        int maxCharCount = 0;
        int[] counts = new int[26];
        int res = 0;
        
        while (end < s.length()) {
            char curr = s.charAt(end);
            counts[curr-'A']++;
            if (counts[curr-'A'] > maxCharCount) {
                maxCharCount = counts[curr-'A'];
                maxChar = curr;
            }
            
            while (end - start + 1 - maxCharCount > k) {
                char head = s.charAt(start);
                counts[head-'A']--;
                if (head == maxChar) maxCharCount--;
                
                for (int i = 0; i < 26; i++) {
                    if (counts[i] > maxCharCount) {
                        maxCharCount = counts[i];
                        maxChar = (char)(i + 'A');
                    }
                }
                
                start++;
            }

            res = Math.max(res, end - start + 1);
            end++;
        }
        
        return res;
    }
}
