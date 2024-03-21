package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class CountTriangles {
    public int solution(int[] a) {
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

    public static void main(String[] args) {
        CountTriangles countTriangles = new CountTriangles();
        int[] arr = {10,2,5,1,8,12};
        System.out.println(countTriangles.solution(arr));
    }
}
