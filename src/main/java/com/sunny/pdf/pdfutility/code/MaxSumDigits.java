package com.sunny.pdf.pdfutility.code;

public class MaxSumDigits {
    public String solution(String S) {
        char[] digits = S.toCharArray();
        int n = digits.length;

        // Find the first digit that is greater than the next digit
        int index = -1;
        for (int i = 0; i < n - 1; i++) {
            if (digits[i] > digits[i + 1]) {
                index = i;
                break;
            }
        }

        // If no such digit found, return S
        if (index == -1) {
            return S;
        }

        // Decrement the digit found and replace subsequent digits with 9
        digits[index] -= 1;
        for (int i = index + 1; i < n; i++) {
            digits[i] = '9';
        }

        // Remove leading zeroes if any
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : digits) {
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            result.append(digit);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MaxSumDigits msd = new MaxSumDigits();
        // Test cases
        System.out.println(msd.solution("123"));  // Output: "119"
        System.out.println(msd.solution("1000")); // Output: "999"
        System.out.println(msd.solution("500"));  // Output: "499"
        System.out.println(msd.solution("1"));    // Output: "0"

        System.out.println(msd.solution("899"));
        System.out.println(msd.solution("10"));
        System.out.println(msd.solution("98"));
    }
}

