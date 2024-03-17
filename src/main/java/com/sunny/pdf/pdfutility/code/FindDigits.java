package com.sunny.pdf.pdfutility.code;

public class FindDigits {

    public static int findDigits(int n) {
        // Write your code here

        String stringVal = String.valueOf(n);
        char[] charArr = stringVal.toCharArray();
        int count = 0;
        for (char c : charArr) {
            int digit = Integer.parseInt(String.valueOf(c));
            if (digit > 0 && n % digit == 0) {
                count += 1;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        findDigits(10);
    }
}
