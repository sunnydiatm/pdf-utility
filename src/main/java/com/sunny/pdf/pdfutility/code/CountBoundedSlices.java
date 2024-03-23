package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class CountBoundedSlices {

    public int countBoundedSlices(int K, int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int t = 0;
        int inf = Arrays.stream(A).map(Math::abs).max().getAsInt();
        int left = 0;
        int right = 0;
        int[] left_lows = new int[A.length];
        int[] left_highs = new int[A.length];
        Arrays.fill(left_lows, inf);
        Arrays.fill(left_highs, -inf);
        int critical = 0;
        int right_low = inf;
        int right_high = -inf;

        while (left < A.length) {
            while (right < A.length && Math.max(left_highs[left], Math.max(right_high, A[right])) - Math.min(left_lows[left], Math.min(right_low, A[right])) <= K) {
                right_low = Math.min(right_low, A[right]);
                right_high = Math.max(right_high, A[right]);
                right++;
            }

            t += right - left;

            if (left == critical) {
                critical = right;
                int left_low = inf;
                int left_high = -inf;
                for (int x = critical - 1; x > left; x--) {
                    left_low = Math.min(left_low, A[x]);
                    left_high = Math.max(left_high, A[x]);
                    left_lows[x] = left_low;
                    left_highs[x] = left_high;
                }
                right_low = inf;
                right_high = -inf;
            }
            left++;
        }
        return t;
    }

    public static void main(String[] args) {
        CountBoundedSlices slices = new CountBoundedSlices();
        int[] arr = {3,5,7,6,3};
        System.out.println(slices.countBoundedSlices(2, arr));
    }
}
