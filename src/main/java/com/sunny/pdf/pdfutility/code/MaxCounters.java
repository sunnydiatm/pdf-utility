package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int lastMax = 0;

        for (int operation : A) {
            if (operation >= 1 && operation <= N) {
                // increase(X) operation
                int X = operation - 1;
                counters[X] = Math.max(counters[X], lastMax) + 1;
                maxCounter = Math.max(maxCounter, counters[X]);
            } else if (operation == N + 1) {
                // max counter operation
                lastMax = maxCounter;
            }
        }

        // Update counters that haven't been set to lastMax
        for (int i = 0; i < counters.length; i++) {
            counters[i] = Math.max(counters[i], lastMax);
        }

        return counters;
    }

    public static void main(String[] args) {
        int N = 5; // Number of counters
        int[] A = {3, 4, 4, 6, 1, 4, 4}; // Operations array
        int[] result = solution(N, A);
        System.out.println("Result: " + Arrays.toString(result)); // Output: [3, 2, 2, 4, 2]
    }
}

