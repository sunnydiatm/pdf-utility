package com.sunny.pdf.pdfutility.code;

public class TapeEquilibrium {

    public static int solution(int[] A) {
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int minDiff = Integer.MAX_VALUE;
        int leftSum = 0;

        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            int rightSum = totalSum - leftSum;
            int diff = Math.abs(leftSum - rightSum);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3}; // Example input array
        int minDiff = solution(A);
        System.out.println("Minimum absolute difference: " + minDiff); // Output: 1
    }
}

