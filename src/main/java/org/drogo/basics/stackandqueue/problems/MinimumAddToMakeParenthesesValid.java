package org.drogo.basics.stackandqueue.problems;

import java.util.Stack;

/*  921. Minimum Add to Make Parentheses Valid
 *   https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/ */
public class MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.size();

    }

    public static void main(String[] args) {
        String input1="(((";
        String input2="())";
        System.out.println(minAddToMakeValid(input1));
        System.out.println(minAddToMakeValid(input2));
    }
}
