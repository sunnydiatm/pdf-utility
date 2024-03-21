package com.sunny.pdf.pdfutility.code;

public class NailingPlanks {

    public int solution(int[] a, int[] b, int[] c) {
        final int[] nails = new int[2 * c.length + 1];
        int begin = 0;
        int end = c.length;
        int result = -1;
        // binary search. O(log(M)) times
        while(begin <= end) {
            int middle = (begin + end) / 2;
            // prepare helper array. O(M)
            for (int i = 0; i < nails.length; i++) {
                nails[i] = 0;
            }
            // set existing nails to 1. O(M)
            for (int i = 0; i < middle; i++) {
                nails[c[i]] = 1;
            }
            // count nails from 0 to i. O(M)
            int counter = 0;
            for (int i = 0; i < nails.length; i++) {
                if (nails[i] == 1) {
                    counter++;
                }
                nails[i] = counter;
            }
            // find nails number between a[i] and b[i]
            boolean found = true;
            for (int i = 0; i < a.length; i++) {
                if (nails[b[i]] - nails[a[i] - 1] == 0) {
                    found = false;
                    break;
                }
            }
            if (found) {
                end = middle - 1;
                result = middle;
            } else {
                begin = middle + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NailingPlanks planks = new NailingPlanks();
        int[] arr1 = {1,4,5,8};
        int[] arr2 = {4,5,9,10};
        int[] arr3 = {4,6,7,10,2};
        System.out.println(planks.solution(arr1, arr2, arr3));
    }

}
