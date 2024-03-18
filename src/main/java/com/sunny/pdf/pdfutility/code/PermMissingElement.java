package com.sunny.pdf.pdfutility.code;

public class PermMissingElement {

    public static int solution(int[] A) {
        int N = A.length + 1; // Expected length of the array
        int totalSum = N * (N + 1) / 2; // Sum of integers from 1 to N+1
        int arraySum = 0;

        // Calculate the sum of elements in the given array
        for (int num : A) {
            arraySum += num;
        }

        // Calculate the missing element
        return totalSum - arraySum;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5}; // Example input array
        int missingElement = solution(A);
        System.out.println("Missing element: " + missingElement); // Output: 4
    }
}

