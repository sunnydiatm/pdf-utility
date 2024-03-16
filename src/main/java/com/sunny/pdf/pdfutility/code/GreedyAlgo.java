package com.sunny.pdf.pdfutility.code;

public class GreedyAlgo {

    public int maxNonOverlappingSegments(int[] a, int[] b) {
        if (a.length == 0) {
            return 0;
        }
        int result = 0;
        int besti = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > b[besti]) {
                result++;
                besti = i;
            }
        }
        return result + 1;
    }

    public int tieRopes(int k, int[] a) {

        int length = 0;
        int result = 0;
        for (int j : a) {
            length = length + j;
            if (length >= k) {
                result++;
                length = 0;
            }
        }

        return result;
    }
}
