package com.gl.dsa;

import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "([[{}]]))";
        if (isBalanced(input)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
	}

	private static boolean isBalanced(String input) {
		// TODO Auto-generated method stub
		
        Stack<Character> stack = new Stack<>();
        
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;  
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
	}
}
