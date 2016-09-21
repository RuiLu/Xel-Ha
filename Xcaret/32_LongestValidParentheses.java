public class Solution {
    /**
     *  Dynamic programming
     *  
     *  Scan string from left to right, once meeting '(', push it into stack,
     *  once meeting ')', determine whether top of stack has '(', if so, find one valid parentheses pair
     *  
     *  Time complexity -> O(n)
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        
        int max = 0;
        int[] count = new int[s.length()];
        char[] sca = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < sca.length; i++) {
            if (sca[i] == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                int start = stack.pop();
                count[i] = i - start + 1;
                if (start >= 1) count[i] += count[start - 1];
                max = Math.max(max, count[i]);
            }
        }
        
        return max;
    }
    
    /**
     *  Without a stack
     *  Reference -> https://discuss.leetcode.com/topic/2426/my-dp-o-n-solution-without-using-stack
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        
        char[] sca = s.toCharArray();
        int[] longest = new int[sca.length];
        int max = 0;
        
        for (int i = 1; i < sca.length; i++) {
            if (sca[i] == ')' && i-1-longest[i-1] >= 0 && sca[i-1-longest[i-1]] == '(') {
                longest[i] = longest[i-1] + 2 + ((i-2-longest[i-1] >= 0) ? longest[i-2-longest[i-1]] : 0);
                max = Math.max(max, longest[i]);
            }
        }
        
        return max;
    } 
}
