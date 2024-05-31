package com.sunny.pdf.pdfutility.code;

public class MaxSumDigits {
    public String solution(String S) {
        int n = S.length();
        char[] chars = S.toCharArray();

        // Traverse the string from the end to find the first non-zero digit to decrement
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] != '0') {
                // Decrement this digit by 1
                chars[i]--;
                // Set all subsequent digits to '9'
                for (int j = i + 1; j < n; j++) {
                    chars[j] = '9';
                }
                // Convert back to string and handle any potential leading zeros
                String result = new String(chars);
                // Remove any leading zeros that may appear due to the decrement
                result = result.replaceFirst("^0+(?!$)", "");
                return result;
            }
        }

        // If we can't decrement any digit (e.g., "1"), the result is "0"
        return "0";
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

