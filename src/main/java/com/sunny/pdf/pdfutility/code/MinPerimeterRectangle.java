package com.sunny.pdf.pdfutility.code;

public class MinPerimeterRectangle {

    public int minPerimeterRectangle(int N) {
        int minPerimeter = Integer.MAX_VALUE;

        // Iterate over factors of N
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                int factor1 = i;
                int factor2 = N / i;

                // Calculate perimeter for the current pair of factors
                int perimeter = 2 * (factor1 + factor2);

                // Update minPerimeter if the current perimeter is smaller
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }
}
