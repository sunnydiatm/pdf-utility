package com.sunny.pdf.pdfutility.code;

public class PermCheck {

    public static int solution(int[] A) {
        int N = A.length;
        boolean[] seen = new boolean[N + 1]; // Initialize boolean array to keep track of elements

        for (int num : A) {
            if (num < 1 || num > N || seen[num]) {
                return 0; // If the element is out of range or already seen, it's not a permutation
            }
            seen[num] = true; // Mark the element as seen
        }

        // Check if all elements from 1 to N are present in the array
        for (int i = 1; i <= N; i++) {
            if (!seen[i]) {
                return 0; // If any element is missing, it's not a permutation
            }
        }

        return 1; // If all conditions are satisfied, it's a permutation
    }

    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2}; // Example input array
        int isPermutation = solution(A);
        System.out.println("Is permutation: " + isPermutation); // Output: 1 (true)
    }
}
