public class Solution {
    /**
     *  Using a stack, determine whether it is valid parentheses during travasing
     *  After traverse, determin whether stack is empty or not
     * 
     *  Time complexity -> O(n)
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (ch == '}') {
                if (stack.isEmpty() ||stack.pop() != '{') return false;
            } else if (ch == ']') {
                if (stack.isEmpty() ||stack.pop() != '[') return false;
            } else {
                return false;
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
}

