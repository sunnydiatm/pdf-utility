package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class Triangle {

    public int solution(int[] A) {
        int N = A.length;
        if (N < 3) {
            return 0; // Not enough elements to form a triplet
        }

        Arrays.sort(A); // Sort the array in non-decreasing order

        for (int i = 0; i < N - 2; i++) {
            long P = A[i];
            long Q = A[i + 1];
            long R = A[i + 2];

            // Check if triangular triplet exists
            if (P + Q > R && Q + R > P && R + P > Q) {
                return 1;
            }
        }

        return 0; // No triangular triplet found
    }

    public static void main(String[] args) {
        Triangle solution = new Triangle();
        int[] A = {10, 2, 5, 1, 8, 20};
        System.out.println(solution.solution(A)); // Output: 1
    }
}
