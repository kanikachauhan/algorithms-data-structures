package com.algorithms.stk;

public class StackOperationOne {

	
	public static String convertPrefixToInfix(String prefix) {
		ArrayStack<String> wcharStack = new ArrayStack<String>();
		int len = prefix.length()-1;
		for(int i=len;i>=0;i--) {
			char c = prefix.charAt(i);
			if(!isSymbol(c)) {
				wcharStack.push(c+"");
			}else {
				String c1 = wcharStack.pop();
				String c2 = wcharStack.pop();
				String res = "("+c1+""+c+""+c2+")";
				wcharStack.push(res);
			}
		}
		return wcharStack.pop();
	}
	
	public static String convertPostfixToPrefix(String postfix) {
		ArrayStack<String> wcharStack = new ArrayStack<String>();
		int len = postfix.length();
		String res = "";
		for(int i=0;i<len;i++) {
			char c = postfix.charAt(i);
			if(!isSymbol(c)) {
				wcharStack.push(c+"");
			}else {
				String c1 = wcharStack.pop();
				String c2 = wcharStack.pop();
				res = c+c2+c1+"";
				wcharStack.push(res);
			}
		}
		return wcharStack.pop();
	}
	
	public static String convertPrefixToPostfix(String prefix) {
		ArrayStack<String> wcharStack = new ArrayStack<String>();
		int len = prefix.length();
		String res = "";
		for(int i=len-1;i>=0;i--) {
			char c = prefix.charAt(i);
			if(!isSymbol(c)) {
				wcharStack.push(c+"");
			}else {
				String c1 = wcharStack.pop();
				String c2 = wcharStack.pop();
				res = c1+c2+c+"";
				wcharStack.push(res);
			}
		}
		return wcharStack.pop();
	}
	
	public static int evaluatePostfix(String postfix) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		int len = postfix.length();
		for(int i=0;i<len;i++) {
			char c = postfix.charAt(i);
			if(!isSymbol(c)) {
				stack.push(Integer.parseInt(Character.toString(c)));
			}else {
				int c1 = stack.pop();
				int c2 = stack.pop();
				switch (c) {
				case '+':
					stack.push(c2 + c1);
					break;
				case '-':
					stack.push(c2 - c1);
					break;
				case '*':
					stack.push(c2 * c1);
					break;
				case '/':
					stack.push(c2 / c1);
					break;
				case '^':
					stack.push(c2 ^ c1);
					break;
				}
			}
		}
		return stack.pop();
	}
	
	public static boolean isBalancedParanthesis(String input) {
		ArrayStack<Character> stack = new ArrayStack<Character>();
		int len = input.length();
		for(int i=0;i<len;i++) {
			char c = input.charAt(i);
			if(c=='{' || c=='(' || c=='[') {
				stack.push(c);
			}
			else {
				if(stack.isEmpty()) {
					return false;
				}
				char temp = stack.pop();
				if((temp!='{' && c=='}') || (temp!='[' && c==']') || (temp!='(' && c==')')) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	private static boolean isSymbol(char c) {
		return c=='/' || c=='*' || c=='+' || c=='^' || c=='-';
	}
}
