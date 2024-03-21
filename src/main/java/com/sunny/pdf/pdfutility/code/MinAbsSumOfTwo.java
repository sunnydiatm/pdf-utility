package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class MinAbsSumOfTwo {

    public int solution(int[] a) {
        Arrays.sort(a);
        int j = a.length - 1;
        int result = Integer.MAX_VALUE;
        for (final int value : a) {
            int best = Math.abs(value + a[j]);
            // beast min abs value for a is -a
            // with j we move from the end to the beginning of the array
            // if abs starts growing, it will never be less again
            // so we find the best value for the i-th element
            // a[i] <= a[i + 1], so a[i + 1]-th best summand is to the left from a[i]-th
            // it cannot be to the right of j-th position (just draw a plot with x axis to see i)
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

    public static void main(String[] args) {
        MinAbsSumOfTwo minAbsSumOfTwo = new MinAbsSumOfTwo();
        int[] arr = {1,4,-3};
        System.out.println(minAbsSumOfTwo.solution(arr));
    }
}
