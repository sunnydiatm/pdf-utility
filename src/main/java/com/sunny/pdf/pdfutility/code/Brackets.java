package com.sunny.pdf.pdfutility.code;

import java.util.Stack;

public class Brackets {

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0; // Unmatched closing bracket
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return 0; // Mismatched opening and closing brackets
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Brackets solution = new Brackets();
        String S1 = "{[()()]}";
        String S2 = "([)()]";
        System.out.println(solution.solution(S1)); // Output: 1
        System.out.println(solution.solution(S2)); // Output: 0
    }
}
