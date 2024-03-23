package com.sunny.pdf.pdfutility.code;

public class CountFactors {

    public int countFactors(int N) { // todo - 100%
        // write your code in Java SE 8
        int factors = 0;
        int sq = (int) Math.sqrt(N);
        if (Math.pow(sq, 2) != N) {
            sq++;
        } else {
            factors++;
        }

        for (int i = 1; i < sq; i++) {
            if (N % i == 0) {
                factors += 2;
            }
        }
        return factors;
    }
}
