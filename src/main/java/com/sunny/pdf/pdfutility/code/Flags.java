package com.sunny.pdf.pdfutility.code;

public class Flags {
    public int solution(int[] A) {
        int N = A.length;
        int[] peaks = new int[N];
        int peakCount = 0;

        // Find all the peaks in the array
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[peakCount++] = i;
            }
        }

        if (peakCount == 0) {
            // No peaks found, so no flags can be set
            return 0;
        }

        int result = 0;
        for (int flags = 1; flags <= peakCount; flags++) {
            int pos = 0;
            int count = 0;
            while (pos < peakCount && count < flags) {
                count++;
                int nextFlag = peaks[pos++] + flags;
                while (pos < peakCount && peaks[pos] < nextFlag) {
                    pos++;
                }
            }
            if (count >= flags) {
                result = flags;
            } else {
                break; // Not enough flags can be set
            }
        }

        return result;
    }

     public static void main(String[] args) {
            Flags solution = new Flags();
            int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
            System.out.println(solution.solution(A)); // Output: 3
    }
}

