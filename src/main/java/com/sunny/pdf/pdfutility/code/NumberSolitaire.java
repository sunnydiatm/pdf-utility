package com.sunny.pdf.pdfutility.code;

public class NumberSolitaire {

    public int solution(int[] a) {
        final int[] m = new int[a.length];
        m[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            int j = 1;
            m[i] = Integer.MIN_VALUE;
            while (j < 7 && i - j >= 0) {
                if (m[i] < a[i] + m[i - j]) {
                    m[i] = a[i] + m[i - j];
                }
                j++;
            }
        }
        return m[m.length - 1];
    }

    public static void main(String[] args) {
        NumberSolitaire numberSolitaire = new NumberSolitaire();
        int[] arr1 = {1,-2,0,9,-1,-2};
        System.out.println(numberSolitaire.solution(arr1));
    }
}
