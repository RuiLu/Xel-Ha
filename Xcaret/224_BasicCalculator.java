public class Solution {
    /**
     *  Idea -> using two stacks, one for operands, one for operators.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '+' || curr == '-') {
                operators.push(curr);
            } else if (curr == ')') {
                operators.pop();
                if (!operators.isEmpty() && operators.peek() == '+') {
                    int a = operands.pop();
                    int b = operands.pop();
                    operators.pop();
                    operands.push(a + b);
                } else if (!operators.isEmpty() && operators.peek() == '-') {
                    int a = operands.pop();
                    int b = operands.pop();
                    operators.pop();
                    operands.push(b - a);
                }
            } else if (Character.isDigit(curr)) {
                int start = i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
                int value = Integer.parseInt(s.substring(start, i));
                
                if (!operators.isEmpty() && operators.peek() == '+') {
                    value = value + operands.pop();
                    operators.pop();
                } else if (!operators.isEmpty() && operators.peek() == '-') {
                    value = operands.pop() - value;
                    operators.pop();
                }
               
                operands.push(value);
                i--;
            }
        }
       
        return operands.pop();
    }
}
