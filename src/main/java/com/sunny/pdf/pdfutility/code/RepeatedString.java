package com.sunny.pdf.pdfutility.code;

public class RepeatedString {

    static long repeatedString(String str, long n) {
        /* Found out # of times 'a' appears in our String */
        int wordAs = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                wordAs++;
            }
        }

        long completeWords    = n / str.length();
        long remainingLetters = n % str.length();
        long totalAs          = completeWords * wordAs;

        /* Count up the remaining 'a' characters */
        for (int i = 0; i < remainingLetters; i++) {
            if (str.charAt(i) == 'a') {
                totalAs++;
            }
        }

        return totalAs;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("abcac", 10));
    }
}
