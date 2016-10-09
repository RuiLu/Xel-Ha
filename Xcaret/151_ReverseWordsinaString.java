public class Solution {
    /**
     *  Using a stack
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) != ' ') {
                int start = i;
                i++;
                while (i < s.length() && s.charAt(i) != ' ') i++;
                stack.push(s.substring(start, i));
            } else {
                i++;
            }
        }
        
        while (!stack.isEmpty()) {
            if (stack.size() == 1) sb.append(stack.pop());
            else sb.append(stack.pop() + " ");
        }
        
        return sb.toString();
    }
}
