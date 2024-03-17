package com.sunny.pdf.pdfutility.code;

public class TaumBday {

    public static long taumBday(int B, int W, int X, int Y, int Z) {
        // Write your code here

        long priceB = Math.min(X, Y + Z); // conversion price
        long priceW = Math.min(Y, X + Z); // conversion price

        //System.out.println(B * priceB + W * priceW);

        return B * priceB + W * priceW;
    }
}
