public class Solution {
    /**
     *  Idea -> Using a stack to store each word
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) != ' ') {
                int start = index;
                while (index < s.length() && s.charAt(index) != ' ') index++;
                stack.push(s.substring(start, index));
                index--;
            }
            index++;
        }
        
        while (!stack.isEmpty()) {
            if (stack.size() == 1) sb.append(stack.pop());
            else sb.append(stack.pop() + " ");
        }
        
        return sb.toString();
    }
    
}
