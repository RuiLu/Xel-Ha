public class Solution {
    /**
     *  Idea -> Dynamic programming
     *          If s.charAt(i) == '(', set dp[i] to 0, because any string ends with '(' is invalid.
     *          If s.charAt(i) == ')':
     *              If s.charAt(i-1) is '(', set dp[i] = dp[i-2] + 2;
     *              If s.charAt(i-1) is ')' and s.charAt(i-dp[i-1]-1) is '(', set dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2].
     * 
     *  Time complexity -> O(n). (Array operations are faster than Stack operations.)
     *  Space complexity -> O(n)
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] dp = new int[s.length()];
        int max = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i-2 >= 0 ? dp[i-2] : 0) + 2;
                    max = Math.max(max, dp[i]);
                } else if (s.charAt(i-1) == ')') {
                    if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                        dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }
        
        return max;
    }
    
    /**
     *  Idea -> Using a Stack, the elements of stack is index.
     *          1. Scan the string from left to right;
     *          2. If current character is '(', push it into stack.
     *             If current character is ')' and peek of stack is '(', 
     *             then we find one valid pair and pop '(' from stack.
     *          3. After scan is done, if stack is empty, then the whole string is valid.
     *             If stack is not empty, then stack only contains indices of character which cannot be matched.
     *             Then we can calculate the substring between left indices to get longest valid parentheses.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        
        if (stack.isEmpty()) return s.length();
        
        int longest = 0;
        int end = len;
        while (!stack.isEmpty()) {
            int start = stack.pop();
            longest = Math.max(longest, end - start - 1);
            end = start;
        }
        longest = Math.max(longest, end);
        
        return longest;
    }
}
