package com.sunny.pdf.pdfutility.code;

public class ModifiedKaprekarNumbers {

    public static void kaprekarNumbers(int p, int q) {
        boolean found = false;
        for (int i = p; i <= q; i++) {
            if (isModifiedKaprekarNumber(i)) {
                found = true;
                System.out.print(i + " ");
            }
        }
        if (!found) {
            System.out.println("INVALID RANGE");
        }
    }

    private static boolean isModifiedKaprekarNumber(int n) {
        long square = (long) n * n;
        String squareStr = String.valueOf(square);
        int d = String.valueOf(n).length();

        String rightStr = squareStr.substring(squareStr.length() - d);
        String leftStr = squareStr.substring(0, squareStr.length() - d);
        int right = (rightStr.isEmpty()) ? 0 : Integer.parseInt(rightStr);
        int left = (leftStr.isEmpty()) ? 0 : Integer.parseInt(leftStr);

        return (left + right == n);
    }

    public static void main(String[] args) {
        int p = 1;
        int q = 100;
        kaprekarNumbers(p, q);
    }
}

