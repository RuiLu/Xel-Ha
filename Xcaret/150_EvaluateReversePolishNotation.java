public class Solution {
    /**
     *  Using a stack to store number
     *  Pay attention to the pop sequence of numbers
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            int first = 0;
            int second = 0;
            if (token.equals("+")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first + second);
            } else if (token.equals("-")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first - second);
            } else if (token.equals("*")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first * second);
            } else if (token.equals("/")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
