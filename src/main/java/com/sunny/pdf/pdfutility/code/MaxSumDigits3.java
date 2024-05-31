package com.sunny.pdf.pdfutility.code;

public class MaxSumDigits3 {
    public String solution(String S) {
        int n = S.length();
        char[] chars = S.toCharArray();

        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] != '0') {
                chars[i]--;
                for (int j = i + 1; j < n; j++) {
                    chars[j] = '9';
                }
                String result = new String(chars);
                return result.replaceFirst("^0+(?!$)", "");
            }
        }

        return "0";
    }


    public static void main(String[] args) {
        MaxSumDigits3 msd = new MaxSumDigits3();
        // Test cases
        System.out.println(msd.solution("123"));  // Output: "119"
        System.out.println(msd.solution("1000")); // Output: "999"
        System.out.println(msd.solution("500"));  // Output: "499"
        System.out.println(msd.solution("1"));

        System.out.println(msd.solution("899"));
        System.out.println(msd.solution("10"));
        System.out.println(msd.solution("98"));
    }
}

