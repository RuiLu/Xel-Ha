public class Solution {
    public int longestValidParentheses(String s) {
        int[] a = new int[s.length()];
        char[] c = s.toCharArray();
        int max = 0, start = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                start = stack.pop();
                a[i] = i - start + 1;
                if (start > 1) a[i] += a[start - 1];
                max = Math.max(max, a[i]);
            }
        }
        return max;
    }
}
