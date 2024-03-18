package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class NumberOfDiscIntersections {

    public int solution(int[] A) {
        int N = A.length;
        long[] left = new long[N];
        long[] right = new long[N];

        // Calculate the left and right endpoints of each interval
        for (int i = 0; i < N; i++) {
            left[i] = (long) i - A[i];
            right[i] = (long) i + A[i];
        }

        // Sort the intervals by their left endpoints
        Arrays.sort(left);
        Arrays.sort(right);

        int openDiscs = 0;
        int intersectCount = 0;
        int j = 0;

        // Count the intersecting pairs
        for (int i = 0; i < N; i++) {
            while (j < N && right[i] >= left[j]) {
                openDiscs++;
                j++;
            }
            openDiscs--; // Decrease count when a disc ends
            intersectCount += openDiscs; // Count intersecting pairs
            if (intersectCount > 10000000) {
                return -1; // Return -1 if count exceeds 10,000,000
            }
        }

        return intersectCount;
    }

    public static void main(String[] args) {
        NumberOfDiscIntersections solution = new NumberOfDiscIntersections();
        int[] A = {1, 5, 2, 1, 4, 0};
        System.out.println(solution.solution(A)); // Output: 11
    }
}
