public class Solution {
    /**
     *  Need extra space
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        
        Queue<String> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int prev = len;
        
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (i + 1 != prev) queue.offer(s.substring(i + 1, prev));
                prev = i;
            } 
        }
        if (prev != 0) queue.offer(s.substring(0, prev));
        
        while (!queue.isEmpty()) {
            if (queue.size() == 1) sb.append(queue.poll());
            else sb.append(queue.poll() + " ");
        }
        
        return sb.toString();
    }
}
