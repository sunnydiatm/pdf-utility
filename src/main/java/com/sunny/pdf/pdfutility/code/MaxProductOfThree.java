package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class MaxProductOfThree {

    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);

        // Case 1: Product of the three largest numbers
        int maxProduct1 = A[N - 1] * A[N - 2] * A[N - 3];

        // Case 2: Product of the two smallest negative numbers and the largest positive number
        int maxProduct2 = A[0] * A[1] * A[N - 1];

        return Math.max(maxProduct1, maxProduct2);
    }

    public static void main(String[] args) {
        MaxProductOfThree solution = new MaxProductOfThree();
        int[] A = {-3, 1, 2, -2, 5, 6};
        System.out.println(solution.solution(A)); // Output: 60
    }
}
