package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;

        // Initialize prefix sums for each nucleotide
        int[][] prefixSums = new int[4][N + 1];

        // Calculate prefix sums
        for (int i = 0; i < N; i++) {
            int a = 0, c = 0, g = 0, t = 0;
            char ch = S.charAt(i);
            if (ch == 'A') {
                a = 1;
            } else if (ch == 'C') {
                c = 1;
            } else if (ch == 'G') {
                g = 1;
            } else if (ch == 'T') {
                t = 1;
            }
            prefixSums[0][i + 1] = prefixSums[0][i] + a;
            prefixSums[1][i + 1] = prefixSums[1][i] + c;
            prefixSums[2][i + 1] = prefixSums[2][i] + g;
            prefixSums[3][i + 1] = prefixSums[3][i] + t;
        }

        // Process queries
        int[] result = new int[M];
        for (int k = 0; k < M; k++) {
            int start = P[k];
            int end = Q[k] + 1;
            if (prefixSums[0][end] - prefixSums[0][start] > 0) {
                result[k] = 1;
            } else if (prefixSums[1][end] - prefixSums[1][start] > 0) {
                result[k] = 2;
            } else if (prefixSums[2][end] - prefixSums[2][start] > 0) {
                result[k] = 3;
            } else {
                result[k] = 4;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GenomicRangeQuery solution = new GenomicRangeQuery();
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] result = solution.solution(S, P, Q);
        System.out.println(Arrays.toString(result)); // Output: [2, 4, 1]
    }
}
