package com.sunny.pdf.pdfutility.code;

public class AbsDistinct {

    public int solution(int[] a) {
        final int[] negatives = new int[a.length];
        int i = 0;
        int j = 0;
        int prev = 1;
        int result = 0;
        for (; i < a.length && a[i] < 0; i++) {
            if (prev != a[i]) {
                negatives[j] = -a[i];
                prev = a[i];
                j++;
                result++;
            }
        }
        prev = -1;
        for (--j; i < a.length; i++) {
            while (j >= 0 && negatives[j] < a[i]) {
                j--;
            }
            if (j < 0 || negatives[j] != a[i]) {
                if (prev != a[i]) {
                    result++;
                    prev = a[i];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AbsDistinct absDistinct = new AbsDistinct();
        int[] arr1 = {-5,-3,-1,0,3,6};
        System.out.println(absDistinct.solution(arr1));
    }
}
