package com.sunny.pdf.pdfutility.code;

import java.util.Stack;

public class DisappearingPairs {

    public String disappearingPairs(String S) {
        Stack<Character> stack = new Stack<>();
        for (char s : S.toCharArray()) {
            if (!stack.isEmpty() && s == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(s);
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        DisappearingPairs pairs = new DisappearingPairs();
        System.out.println(pairs.disappearingPairs("ACCAABBC"));
        System.out.println(pairs.disappearingPairs("BABABA"));
    }
}
