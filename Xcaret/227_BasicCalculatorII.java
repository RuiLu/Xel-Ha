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
        int len = s.length();
        int num = 0;
        char sign = '+';
        
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = 10 * num + (s.charAt(i) - '0');
            }
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num); 
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        
        return res;
    }
}
