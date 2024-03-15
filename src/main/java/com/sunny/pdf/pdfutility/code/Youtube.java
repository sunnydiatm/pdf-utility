package com.sunny.pdf.pdfutility.code;

public class Youtube {

    public int minimumCoinFlip(int[] A) {
        int flipsStartWithHeads = 0;
        int flipsStartWithTails = 0;

        // Case 1: Starting with heads (H)
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0 && A[i] == 1) {
                flipsStartWithHeads++;
            } else if (i % 2 == 1 && A[i] == 0) {
                flipsStartWithHeads++;
            }
        }

        // Case 2: Starting with tails (T)
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0 && A[i] == 0) {
                flipsStartWithTails++;
            } else if (i % 2 == 1 && A[i] == 1) {
                flipsStartWithTails++;
            }
        }

        return Math.min(flipsStartWithHeads, flipsStartWithTails);
    }

    public int letterOccurrence(String S) {

        int deletions = 0;
        int countB = 0;

        for (char c : S.toCharArray()) {
            if (c == 'A') {
                deletions = Math.min(deletions + 1, countB); // Either delete 'A' or 'B'
            } else {
                countB++;
            }
        }

        return deletions;

    }
}
