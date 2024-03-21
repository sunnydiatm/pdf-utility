package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class FairRations {

    public static String fairRations(List<Integer> B) { // todo - working in test but not in local
        int n = B.size();
        int loaves = 0;

        for (int i = 0; i < n - 1; i++) {
            if (B.get(i) % 2 == 1) {
                B.set(i, B.get(i) + 1);
                B.set(i + 1, B.get(i + 1) + 1);
                loaves += 2;
            }
        }

        if (B.get(n - 1) % 2 == 1) {
            return "NO";
        }

        return Integer.toString(loaves);
    }

    public static void main(String[] args) {
        List<Integer> B = List.of(2, 3, 4, 5, 6);
        System.out.println(fairRations(B)); // Output: 4
    }
}
