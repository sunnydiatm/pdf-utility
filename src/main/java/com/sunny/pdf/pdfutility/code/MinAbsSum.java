package com.sunny.pdf.pdfutility.code;

public class MinAbsSum {

    public int solution(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        // O(N)
        for (int i = 0; i < a.length; i++) {
            final int value = Math.abs(a[i]);
            sum += value;
            if (max < value) {
                max = value;
            }
            a[i] = value;
        }
        // O(max(abs(a))) space but no more than O(sum(abs(a))), so ignore it
        // O(N)
        final int[] counts = new int[max + 1];
        for (int value: a) {
            counts[value]++;
        }
        // O(sum(abs(a)))
        final int[] r = new int[sum + 1];
        for (int i = 1; i < r.length; i++) {
            r[i] = -1;
        }
        // outer is O(max(abs(a)))
        // inner is O(sum(abs(a))) which is less than O(N * max(abs(a)))
        // we don't care of 0 values
        for (int i = 1; i < counts.length; i++) {
            // we check r[j]. if it's not less than 0, then it means we've reached j value with previous steps, so no need to spend current
            // if it's less than 0, spend 1 current number if r[j - i] has been reached
            for (int j = 0; j < r.length; j++) {
                // negative value means we haven't reached this value, so we have to spend 1 current if we can
                if (r[j] >= 0) {
                    r[j] = counts[i];
                } else if (j - i >= 0 && r[j - i] > 0) {
                    r[j] = r[j - i] - 1;
                }
                // the value in r[j] then means how many of the current values are left when we reached the value j
            }
        }
        int result = sum;
        // don't have to traverse all the arrays, since i - the sum of elements. if it's reachable then (sum - i) - reachable as well.
        // so if the value is reachable then the diff is abs(i - (sum - i)), which is the same as abs(sum - 2 * i)
        for (int i = 0; i < r.length / 2 + 1; i++) {
            if (r[i] >= 0 && result > Math.abs(sum - 2 * i)) {
                result = Math.abs(sum - 2 * i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinAbsSum minAbsSum = new MinAbsSum();
        int[] arr1 = {1,5,2,-2};
        System.out.println(minAbsSum.solution(arr1));
    }
}
