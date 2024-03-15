package com.sunny.pdf.pdfutility.code;

public class MaximumSliceProblem {

        public int computeMaxEarning(int[] prices) {
            if (prices == null || prices.length < 2) {
                return 0; // Cannot earn anything with less than 2 prices
            }

            int maxEarning = 0;
            int minPrice = prices[0];

            for (int i = 1; i < prices.length; i++) {
                maxEarning = Math.max(maxEarning, prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }

            return maxEarning;
        }

    public int maxSliceSum(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int maxSum = A[0];
        int currentSum = A[0];

        for (int i = 1; i < A.length; i++) {
            currentSum = Math.max(A[i], currentSum + A[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public int maxDoubleSliceSum(int[] A) {
        int[] maxEnding = new int[A.length];
        int[] maxStarting = new int[A.length];

        // Calculate maximum sum ending at each index
        for (int i = 1; i < A.length - 1; i++) {
            maxEnding[i] = Math.max(0, maxEnding[i - 1] + A[i]);
        }

        // Calculate maximum sum starting at each index
        for (int i = A.length - 2; i > 0; i--) {
            maxStarting[i] = Math.max(0, maxStarting[i + 1] + A[i]);
        }

        int maxDoubleSliceSum = 0;

        // Find the maximum double slice sum
        for (int i = 1; i < A.length - 1; i++) {
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, maxEnding[i - 1] + maxStarting[i + 1]);
        }

        return maxDoubleSliceSum;
    }

}
