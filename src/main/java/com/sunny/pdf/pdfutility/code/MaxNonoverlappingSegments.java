package com.sunny.pdf.pdfutility.code;

public class MaxNonoverlappingSegments {

    public int solution(int[] a, int[] b) {
        if (a.length == 0) {
            return 0;
        }
        int result = 0;
        int besti = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > b[besti]) {
                result++;
                besti = i;
            }
        }
        return result + 1;
    }

    public static void main(String[] args) {
        MaxNonoverlappingSegments maxNonoverlappingSegments = new MaxNonoverlappingSegments();
        int[] arr1 = {1,3,7,9,9};
        int[] arr2 = {5,6,8,9,10};
        System.out.println(maxNonoverlappingSegments.solution(arr1, arr2));
    }
}
