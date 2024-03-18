package com.sunny.pdf.pdfutility.code;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public static int solution(int X, int[] A) {
        Set<Integer> leafPositions = new HashSet<>();

        for (int time = 0; time < A.length; time++) {
            int leafPosition = A[time];
            leafPositions.add(leafPosition);

            if (leafPositions.size() == X) {
                return time;
            }
        }

        return -1; // If all positions are not covered
    }

    public static void main(String[] args) {
        int X = 5; // Target position
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4}; // Array of leaf positions
        int earliestTime = solution(X, A);
        System.out.println("Earliest time to cross: " + earliestTime); // Output: 6
    }
}

