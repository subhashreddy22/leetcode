package com.leetcode.stack;

import java.util.Stack;

public class ValidParantheses {

    public boolean isValid(String s) {

        if (s == null || s.isEmpty() || s.length() == 1) {
            return false;
        }

        char[] chArr = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char ch : chArr) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    char poppedChar = stack.pop();
                    if ((ch == ')' && poppedChar != '(') || (ch == ']' && poppedChar != '[') || (ch == '}' && poppedChar != '{')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
