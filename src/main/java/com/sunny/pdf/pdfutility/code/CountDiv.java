package com.sunny.pdf.pdfutility.code;

public class CountDiv {

    public int solution(int A, int B, int K) {
        int divisibleByKInB = B / K;
        int divisibleByKInA = (A - 1) / K;
        return divisibleByKInB - divisibleByKInA;
    }

    public static void main(String[] args) {
        CountDiv solution = new CountDiv();
        int A = 6, B = 11, K = 2; // Example values of A, B, and K
        int divisibleCount = solution.solution(A, B, K);
        System.out.println("Number of integers divisible by " + K + " in range [" + A + ".." + B + "]: " + divisibleCount); // Output: 3
    }
}
