package com.sunny.pdf.pdfutility.code;

import java.math.BigInteger;

public class LongFactorial {

    public static void extraLongFactorials(int n) {
        // Write your code here

        BigInteger sum = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(sum);

    }

    public static void main(String[] args) {
        extraLongFactorials(20);
    }
}
