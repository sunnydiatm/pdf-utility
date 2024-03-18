package com.sunny.pdf.pdfutility.code;

public class PassingCars {

    public int solution(int[] A) {
        int eastwardCarsCount = 0;
        int passingCarsCount = 0;

        for (int car : A) {
            if (car == 0) {
                eastwardCarsCount++;
            } else {
                passingCarsCount += eastwardCarsCount;
                if (passingCarsCount > 1000000000) {
                    return -1; // Return -1 if passing cars count exceeds 1,000,000,000
                }
            }
        }

        return passingCarsCount;
    }

    public static void main(String[] args) {
        PassingCars solution = new PassingCars();
        int[] A = {0, 1, 0, 1, 1}; // Example array A
        int passingCars = solution.solution(A);
        System.out.println("Number of passing cars: " + passingCars); // Output: 5
    }
}
