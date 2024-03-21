package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurfaceArea3D {

    public static int surfaceArea(List<List<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();

        int surfaceArea = 0;

        // Iterate over each cell in the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int height = A.get(i).get(j);
                if (height > 0) {
                    // Calculate surface area contributed by the cubes stacked on this cell
                    surfaceArea += 4 * height + 2;

                    // Subtract the surface area contributed by adjacent cells
                    if (i > 0) {
                        surfaceArea -= Math.min(height, A.get(i - 1).get(j)) * 2;
                    }
                    if (j > 0) {
                        surfaceArea -= Math.min(height, A.get(i).get(j - 1)) * 2;
                    }
                }
            }
        }

        return surfaceArea;
    }

    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(1, 3, 4));
        A.add(Arrays.asList(2, 2, 3));
        A.add(Arrays.asList(1, 2, 4));
        System.out.println(surfaceArea(A)); // Output: 60
    }
}
