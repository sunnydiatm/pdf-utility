package com.sunny.pdf.pdfutility.code;

import java.util.Stack;

public class Nesting {

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return 0; // Not properly nested
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Nesting solution = new Nesting();
        String S1 = "(()(())())";
        String S2 = "())";
        System.out.println(solution.solution(S1)); // Output: 1
        System.out.println(solution.solution(S2)); // Output: 0
    }
}
