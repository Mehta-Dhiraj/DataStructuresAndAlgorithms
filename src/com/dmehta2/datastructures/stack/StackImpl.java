package com.dmehta2.datastructures.stack;

public class StackImpl {
    public static void main(String[] args) {

        System.out.println(isParenthesisBalanced("{()"));
    }

    public static boolean isParenthesisBalanced(String str) {
        Stack<Character> stack = new Stack<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            } else {
                if (str.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (str.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (str.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}