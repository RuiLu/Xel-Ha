public class Solution {
    /**
     *  Using the size of stack to indicate the number of \t
     */
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        
       
        Stack<String> stack = new Stack<>();
        String[] tokens = input.split("\n");
        int res = Integer.MIN_VALUE;
        int count = 0;
        
        for (String token : tokens) {
            int numTab = 0;
            
            // tab can be compared as a character '\t'
            // we need not only calculate '\t', but also ' '
            while (token.charAt(numTab) == '\t') numTab++;
    
            token = token.substring(numTab);
            
            while (numTab < stack.size()) {
                count -= stack.peek().length() + 1;
                stack.pop();
            }
            
            if (token.contains(".")) {
                res = Math.max(res, count + token.length());
            } else {
                stack.push(token);
                count += token.length() + 1;
            }
            
            
        }
        
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
