package com.sunny.pdf.pdfutility.code;

public class MissingInteger {

    public int solution(int[] A) {
        int N = A.length;
        boolean[] present = new boolean[N + 2]; // Extra space for 1-based indexing

        // Mark the presence of integers from 1 to N in array A
        for (int num : A) {
            if (num > 0 && num <= N) {
                present[num] = true;
            }
        }

        // Find the smallest positive integer that does not occur in array A
        for (int i = 1; i <= N + 1; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return 1; // Fallback case (should not reach here)
    }

    public static void main(String[] args) {
        MissingInteger solution = new MissingInteger();
        int[] A = {1, 3, 6, 4, 1, 2}; // Example array A
        int smallestMissing = solution.solution(A);
        System.out.println("Smallest missing positive integer: " + smallestMissing); // Output: 5
    }
}
