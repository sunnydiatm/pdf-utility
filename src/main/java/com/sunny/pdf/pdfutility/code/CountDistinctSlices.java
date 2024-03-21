package com.sunny.pdf.pdfutility.code;

public class CountDistinctSlices {

    public int solution(int m, int[] a) {
        final boolean[] d = new boolean[m + 1];
        int i = 0;
        int j = 0;
        int k = -1;
        long result = 0;
        // total O(N) since i and j are only increasing
        while (j < a.length) {
            long c = 0;
            long n;
            // there will be repeated slices. remove them
            if (k >= 0) {
                n = k - i;
                c = c - (n * (n + 1) / 2l);
            }
            while (j < a.length && !d[a[j]]) {
                d[a[j]] = true;
                j++;
            }
            k = j;
            n = j - i;
            // now count all slices for a fragment. repeated already removed.
            c = c + (n * (n + 1) / 2l);
            result += c;
            // no more than already passed j steps,
            // and no more a.length in total during the solution run
            while (i < j) {
                d[a[i]] = false;
                i++;
                if (k != -1 && k < a.length && a[i - 1] == a[k]) {
                    break;
                }
            }
            if (result > 1000000000) {
                result = 1000000000;
                break;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        CountDistinctSlices countDistinctSlices = new CountDistinctSlices();
        int[] arr1 = {3,4,5,5,2};
        System.out.println(countDistinctSlices.solution(6, arr1));
    }
}
