package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class Caterpillar {

    public int countTriangles(int[] A) {
        int length = A.length;

        if (length <= 2) {
            return 0;
        }

        int result = 0 ;
        for (int i = 0; i < length; i++) {
            int k = i + 2;
            for (int j = i + 1 ; j < length; j++) {
                while (k < length && (A[i] + A[j] <= A[k])) {
                    k +=  1;
                    result +=  k - j - 1;
                }
            }
        }

        return result;
    }

    public int countTriangles2(int[] a) {
        if (a.length < 3) {
            return 0;
        }
        Arrays.sort(a);
        int result = 0;
        for (int p = 0; p < a.length - 2; p++) {
            int q = p + 1;
            for (int r = p + 2; r < a.length; r++) {
                while (q < r && a[p] + a[q] <= a[r]) {
                    q++;
                }
                result = result + r - q;
            }
        }
        return result;
    }

    public int minAbsSumOfTwo(int[] a) {
        Arrays.sort(a);
        int j = a.length - 1;
        int result = Integer.MAX_VALUE;
        for (final int value : a) {
            int best = Math.abs(value + a[j]);
            while (j > 0 && Math.abs(value + a[j - 1]) <= best) {
                j--;
                best = Math.abs(value + a[j]);
            }
            if (result > best) {
                result = best;
            }
        }
        return result;
    }

    public int minAbsSumOfTwo2(int[] a) {
        int best = Integer.MAX_VALUE;;
        for (int k : a) {
            for (int j = 0; j < a.length - 1; j++) {
                int value = Math.abs(k + a[j]);
                if (value < best) {
                    best = value;
                }
            }
        }
        return best;
    }

}
