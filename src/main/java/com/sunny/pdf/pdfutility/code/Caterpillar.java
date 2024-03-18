package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public int absDistinct(int[] a) {
        if (a == null || a.length <= 0) {
            return 0;
        }

        Set<Integer> integerSet = new HashSet<>();

        for (int x: a) {
            integerSet.add(x);
        }

        return  (int) integerSet.stream().map(Math::abs).distinct().count();
    }

    public int countDistinctSlices(int M, int[] A) {
        int N = A.length;
        int distinctSlices = 0;
        Set<Integer> set = new HashSet<>();

        int left = 0;
        for (int right = 0; right < N; right++) {
            while (set.contains(A[right])) {
                set.remove(A[left]);
                left++;
            }
            set.add(A[right]);
            distinctSlices += (right - left + 1);
            if (distinctSlices > 1_000_000_000) {
                return 1_000_000_000;
            }
        }

        return distinctSlices;
    }

    public static void main(String[] args) {
        Caterpillar solution = new Caterpillar();
        int M = 6;
        int[] A = {3, 4, 5, 5, 2};
        System.out.println(solution.countDistinctSlices(M, A)); // Output: 9
    }

}
