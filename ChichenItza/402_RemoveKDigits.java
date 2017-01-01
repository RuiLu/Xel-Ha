public class Solution {
    /**
     *  Idea -> see comments.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || num.length() == k) return "0";
        
        int top = 0;                            // position of the stack top
        char[] stack = new char[num.length()];  // array-like stack
        
        // k represents how many characters we can remove
        // if the previous element in stack is larger than the current one
        // then removing it will get a smaller number
        // but we can only do this when k > 0
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (top > 0 && stack[top-1] > ch && k > 0) {
                top--;
                k--;
            }
            stack[top++] = ch;
        }
        
        int index = 0;
        StringBuilder sb = new StringBuilder();
        
        // avoid the removed character locates on the head of the string
        while (index < top - k && stack[index] == '0') index++;
        // avoid the removed character locates on the tail of the string
        while (index < top - k) sb.append(stack[index++]);
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
