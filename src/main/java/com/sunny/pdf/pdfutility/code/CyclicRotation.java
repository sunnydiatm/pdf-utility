package com.sunny.pdf.pdfutility.code;

public class CyclicRotation {

    public static int[] cyclicRotation(int[] A, int K) {
        int temp = 0;
        int len = A.length;

        if (len < 1) {
            return A;
        }

        for (int i = 0; i < K; i++) {
            temp = A[len - 1];
            for (int j = A.length - 1; j > 0; j--) {
                A[j] = A[j - 1];
            }
            A[0] = temp;
        }
        return A;
    }
}
