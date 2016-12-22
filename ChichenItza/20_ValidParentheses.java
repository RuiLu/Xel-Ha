public class Solution {
    /**
     *  Idea -> Maintain a Character stack.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                else {
                    if (ch == ')' && stack.peek() != '(') return false;
                    if (ch == ']' && stack.peek() != '[') return false;
                    if (ch == '}' && stack.peek() != '{') return false;
                    stack.pop();
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
