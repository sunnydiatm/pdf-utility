package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class LarryArray {

    public static String larrysArray(List<Integer> A) {
        int inversions = countInversions(A);
        return (inversions % 2 == 0) ? "YES" : "NO";
    }

    private static int countInversions(List<Integer> A) {
        int count = 0;
        int n = A.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.get(i) > A.get(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> A = List.of(1,2,3,5,4);
        System.out.println(larrysArray(A)); // Output: YES
    }
}
