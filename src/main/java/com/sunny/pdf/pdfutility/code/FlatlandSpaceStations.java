package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;

public class FlatlandSpaceStations {

    public static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int maxDistance = Math.max(c[0], n - 1 - c[c.length - 1]);

        for (int i = 1; i < c.length; i++) {
            maxDistance = Math.max(maxDistance, (c[i] - c[i - 1]) / 2);
        }

        return maxDistance;

    }

    public static void main(String[] args) {
        int n = 6;
        int[] c = {0,1,2,4,3,5};
        System.out.println(flatlandSpaceStations(n, c)); // Output: 2
    }
}
