/*
 * How to save time: try to avoid operations on String
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> operands = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            /*
             * Must use equals() when doing string comparison
             */
            int second = 0;
            int first = 0;
            if (tokens[i].equals("+")) {
                operands.push(operands.pop() + operands.pop());
            }
            else if (tokens[i].equals("-")) {
                second = operands.pop();
                first = operands.pop();
                operands.push(first - second);
            }
            else if (tokens[i].equals("*")) {
                second = operands.pop();
                first = operands.pop();
                operands.push(first * second);
            }
            else if (tokens[i].equals("/")) {
                second = operands.pop();
                first = operands.pop();
                operands.push(first / second);
            } else {
                operands.push(Integer.parseInt(tokens[i]));
            }
                
        }
        return operands.pop();
    }
}
