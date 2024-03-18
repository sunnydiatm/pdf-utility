package com.sunny.pdf.pdfutility.code;

public class MinAvgTwoSlice {

    public int solution(int[] A) {
        int N = A.length;
        double minAvg = (A[0] + A[1]) / 2.0;
        int minStart = 0;

        for (int i = 0; i < N - 2; i++) {
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;

            if (avg2 < minAvg) {
                minAvg = avg2;
                minStart = i;
            }
            if (avg3 < minAvg) {
                minAvg = avg3;
                minStart = i;
            }
        }

        // Check the last slice of length 2
        double avgLast = (A[N - 2] + A[N - 1]) / 2.0;
        if (avgLast < minAvg) {
            minStart = N - 2;
        }

        return minStart;
    }

    public static void main(String[] args) {
        MinAvgTwoSlice solution = new MinAvgTwoSlice();
        int[] A = {4, 2, 2, 5, 1, 5, 8};
        System.out.println(solution.solution(A)); // Output: 1
    }
}
