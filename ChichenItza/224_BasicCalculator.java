public class Solution {
    /**
     *  Idea -> Two stacks
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int len = s.length();
        int index = 0;
        
        while (index < len) {
            char curr = s.charAt(index);
            if (Character.isDigit(curr)) {
                int start = index;
                while (index < len && Character.isDigit(s.charAt(index))) index++;
                operands.push(Integer.parseInt(s.substring(start, index)));
                continue;
            } else if (curr == '(') {
                operators.push(curr);
            } else if (curr == ')') {
                while (operators.peek() != '(') applyOps(operands, operators);
                operators.pop();
            } else if (curr == '+' || curr == '-') {
                if (!operators.isEmpty() && operators.peek() != '(') applyOps(operands, operators);
                operators.push(curr);
            }
            index++;
        }
        
        while (!operators.isEmpty()) applyOps(operands, operators);
        
        return operands.pop();
    }
    
    private void applyOps(Stack<Integer> operands, Stack<Character> operators) {
        char ops = operators.pop();
        int a = operands.pop();
        int b = operands.pop();
        switch (ops) {
            case '+':
                operands.push(a + b);
                break;
            case '-':
                operands.push(b - a);
                break;
        }
    }
}
