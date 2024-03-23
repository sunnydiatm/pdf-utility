package com.sunny.pdf.pdfutility.code;

public class BinarySparseDecomposition {

    public int solution(int N) {
        // Implement your solution here
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        for (int P = 1; P < N; P++) {
            if (P <= N / 2) {
                String s1 = null;
                String s2 = null;
                String s3 = null;
                String s4 = null;
                int Q = N - P;
                s1 = Integer.toBinaryString(P);
                s2 = s1.substring(1) + "0";
                if ((Integer.parseInt(s1, 2) & Integer.parseInt(s2, 2)) == 0) {
                    s3 = Integer.toBinaryString(Q);
                    s4 = s3.substring(1) + "0";
                    if ((Integer.parseInt(s3, 2) & Integer.parseInt(s4, 2)) == 0) {
                        return P;
                    }
                }
            }
        }
        return -1;
    }
}
