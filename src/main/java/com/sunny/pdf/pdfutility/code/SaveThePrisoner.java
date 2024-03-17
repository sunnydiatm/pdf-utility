package com.sunny.pdf.pdfutility.code;

public class SaveThePrisoner {

    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        return ((s - 1) + (m - 1)) % n + 1;
    }
}
