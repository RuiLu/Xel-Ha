public class Solution {
    /**
     * Idea -> Only use one stack with one helper sign.
     *         The sign record the operator before current number.
     * Time complexity -> O(n)
     * Space complexity -> O(m), where m is the count of number in the given string
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            /* if curr is a digit, add it to num */
            if (Character.isDigit(curr)) num = num*10+(curr-'0');
            
            /* if curr is not a digit or whitespace, 
             * or pointer reaches the last position of s */
            if ((!Character.isDigit(curr) && curr != ' ') || i == s.length()-1) {
                switch(sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                /* we should assign current operator to sign, and reset num */
                sign = curr;
                num = 0;
            }
        }
        
        while (!stack.isEmpty()) res += stack.pop();
        
        return res;
    } 

}
