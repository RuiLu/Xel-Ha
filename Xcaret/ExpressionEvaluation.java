package com.A9;

import java.util.Stack;

public class ExpressionEvaluation {
	public static void main(String[] args) {
		String pattern = "{(5+3 * 2)*(24/6)}";
		ExpressionEvaluation ee = new ExpressionEvaluation();
		System.out.println(pattern + "=" + ee.calculate(pattern));
	}
	
	public ExpressionEvaluation() {}
	
	/* The actual calculate method */
	private int applyOp(char op, int b, int a) {
		System.out.println(Integer.toString(a) + op + Integer.toString(b));
		switch(op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			try {
				return a / b;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/* Determine whether there is precedence ops before */
	private boolean hasPrecedence(char c1, char c2) {
		if (c2 == '(' || c2 == '{') return false;
		else if ((c1 == '*' || c1 == '/') && (c2 == '+' || c2 == '-')) return false;
		else return true; 
	}
	
	public int calculate(String s) {
		char[] sca = s.toCharArray();
		Stack<Integer> values = new Stack<>();
		Stack<Character> ops = new Stack<>();
		
		for (int i = 0; i < sca.length; i++) {
			char curr = sca[i];
			
			if (Character.isDigit(curr)) {	/* Find numbers */
				StringBuilder sb = new StringBuilder();
				while (i < sca.length && Character.isDigit(sca[i])) {
					sb.append(sca[i++]);
				}
				i--;
				values.push(Integer.parseInt(sb.toString()));
			} else if (curr == '(' || curr == '{') {	/* Push left brackets */
				ops.push(curr);
			} else if (curr == ')' || curr == '}') {	/* Meet right brackets, do calculations */
				if (curr == ')') {
					while (!ops.isEmpty() && ops.peek() != '(') {
						values.push(applyOp(ops.pop(), values.pop(), values.pop()));
					}
				} else if (curr == '}') {
					while (!ops.isEmpty() && ops.peek() != '{') {
						values.push(applyOp(ops.pop(), values.pop(), values.pop()));
					}
				}
				ops.pop();
			} else if (curr == '+' || curr == '-' || curr == '*' || curr == '/') {	/* Meet operators, do calculations, but check precidence first*/
				while (!ops.isEmpty() && hasPrecedence(curr, ops.peek())) {
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				}
				ops.push(curr);
			} else if (curr == ' ') {
				continue;
			}
		}
		
		while (!ops.isEmpty()) {
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		}
		
		return values.pop();
	}
}

