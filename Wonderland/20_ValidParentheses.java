/**
 *  Using stack to judge the sequence, and using char[] to determine pairs
 */
public class Solution {
    
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) return false;
        
        int[] ch = new int[3];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                stack.push('(');
                ch[0]++;
            } else if (curr == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
                ch[0]--;
            } else if (curr == '[') {
                stack.push('[');
                ch[1]++;
            } else if (curr == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
                ch[1]--;
            } else if (curr == '{') {
                stack.push('{');
                ch[2]++;
            } else if (curr == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
                ch[2]--;
            }
        }
        
        for (int i : ch) {
            if (i != 0) return false;
        }
        
        return true;
    }
}
