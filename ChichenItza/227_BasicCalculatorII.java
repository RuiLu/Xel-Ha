public class Solution {
    /**
     *  Idea -> Only use one stack with one helper sign.
     *          The sign record the operator before current number.
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> operands = new Stack<>();
        char sign = '+';
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                num = 10 * num + (curr - '0');
            }
            
            if ((!Character.isDigit(curr) && curr != ' ') || (i == s.length() - 1)) {
                switch (sign) {
                    case '+':
                        operands.push(num);
                        break;
                    case '-':
                        operands.push(-num);
                        break;
                    case '*':
                        operands.push(operands.pop() * num);
                        break;
                    case '/':
                        operands.push(operands.pop() / num);
                        break;
                }
                
                sign = curr;
                num = 0;
            }
        }
        
        int res = 0;
        while (!operands.isEmpty()) res += operands.pop();
        
        return res;
    } 
     
    /**
     *  Idea -> Two stacks, need to determine precedence
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int index = 0;
        
        while (index < s.length()) {
            char curr = s.charAt(index);
            if (Character.isDigit(curr)) {
                int start = index;
                while (index < s.length() && Character.isDigit(s.charAt(index))) index++;
                operands.push(Integer.parseInt(s.substring(start, index)));
                continue;
            } else if (curr == '+' || curr == '-' || curr == '*' || curr == '/') {
                while  (!operators.isEmpty() && hasPrecedence(curr, operators.peek())) {
                    applyOps(operands, operators);
                }
                operators.push(curr);
            }
            index++;
        }
        
        while (!operators.isEmpty()) applyOps(operands, operators);
        
        return operands.pop();
    }
    
    private boolean hasPrecedence(char c1, char c2) {
        if ((c1 == '*' || c1 =='/') && (c2 == '+' || c2 == '-')) return false;
        return true;
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
            case '*':
                operands.push(a * b);
                break;
            case '/':
                operands.push(b / a);
                break;
        }
    }
}
