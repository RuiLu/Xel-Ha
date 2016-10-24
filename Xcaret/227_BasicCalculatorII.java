public class Solution {
    /**
     *  Idea -> Using one stack, only compute '*' and '/' in the first round
     *          Then add up all numbers in the stack
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            }
            if ((!Character.isDigit(curr) && curr != ' ') || (i == s.length() - 1)) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                
                sign = curr;
                num = 0;
            }
        }
        
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        
        return res;
    }
}
