package org.drogo.basics.stackandqueue.problems;

import java.util.Stack;

/*  20. Valid Parentheses
 *   https://leetcode.com/problems/valid-parentheses/description/ */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }

                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }

                }
            }

        }
        return stack.isEmpty();

    }

    public static boolean isValidAlternate(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (!stack.isEmpty() && ch == ')' && stack.peek() == '(') {
                stack.pop();

            } else if (!stack.isEmpty() && ch == ']' && stack.peek() == '[') {
                stack.pop();

            } else if (!stack.isEmpty() && ch == '}' && stack.peek() == '{') {
                stack.pop();

            } else return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "()[]{}";
        String input2 = "()[]";
        String input3 = "[]";
        String input4 = "(]";

        System.out.println(isValidAlternate(input1));
        System.out.println(isValidAlternate(input2));
        System.out.println(isValidAlternate(input3));
        System.out.println(isValidAlternate(input4));

    }
}
