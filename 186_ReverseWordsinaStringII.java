public class Solution {
    /**
     *  DO NOT NEED extra space
     *  First reverse the whole sentence, then reverse EACH WORD
     *  Time complexity -> O(n)
     */
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        
        // 1. reverse the whole sentence
        reverse(s, 0, s.length - 1);
        
        // 2. reverse each word
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        
        // 3. reverse the last word
        reverse(s, start, s.length - 1);
    }
    
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
    
    /**
     *  DO NEED extra space
     */
    // public void reverseWords(char[] s) {
    //     if (s == null || s.length == 0) return;
    //     int len = s.length;
    //     int prev = len;
    //     Queue<String> queue = new LinkedList<>();
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = len - 1; i >= 0; i--) {
    //         if (s[i] == ' ') {
    //             int k = i + 1;
    //             while (k < prev) sb.append(s[k++]);
    //             queue.offer(sb.toString());
    //             sb = new StringBuilder();
    //             prev = i;
    //         }
    //     }
    //     int k = 0;
    //     while (k < prev) sb.append(s[k++]);
    //     queue.offer(sb.toString());
        
    //     k = 0;
    //     while (!queue.isEmpty()) {
    //         String word = queue.poll();
    //         for (char ch : word.toCharArray()) s[k++] = ch;
    //         if (k != len) s[k++] = ' ';
    //     }
    // }
}
