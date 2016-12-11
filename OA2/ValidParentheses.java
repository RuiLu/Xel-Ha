package Amazon.OA2;

import java.util.Stack;

/*
 * 给一个String，只包含 '(', ')', '{', '}', '[' 和 ']', 确定该String是否是valid。
 */
public class ValidParentheses {
	
	public static void main(String[] args) {
		System.out.println(validParentheseWithStack("( )[ ]{ }"));
		System.out.println(validParentheseWithStack("([ ]){([ ])}"));
		System.out.println(validParentheseWithStack("([ )]"));
		System.out.println(validParentheseWithStack("([{ ])"));
	}
	
	/**
	 * Time complexity -> O(n)
	 * Space complexity -> O(n)
	 * @param s
	 * @return
	 */
	private static boolean validParentheseWithStack(String s) {
		if (s == null || s.length() == 0) return false;
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (curr == '(' || curr == '{' || curr == '[') {
				stack.push(curr);
			} else if (curr == ')') {
				if (stack.isEmpty() || stack.pop() != '(') return false;
			} else if (curr == '}') {
				if (stack.isEmpty() || stack.pop() != '{') return false;
			} else if (curr == ']') {
				if (stack.isEmpty() || stack.pop() != '[') return false;
			}
		}
		
		return stack.isEmpty();
	}
}

