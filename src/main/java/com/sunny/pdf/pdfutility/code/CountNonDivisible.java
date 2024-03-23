package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountNonDivisible {

    public int[] solution(int[] A) {
        int[][] bucket = new int[A.length * 2 + 1][2];

        // bucket sorting
        for (int a : A) {
            bucket[a][0]++; // remember how many the number "A[i]" in A
            bucket[a][1] = -1; // divisors initialized
        }
        // System.out.println("=="+Arrays.toString(bucket)+"==");
        for (int a : A) {
            if (bucket[a][1] == -1) {
                bucket[a][1] = 0;
                // get all divisors of the integer A[i]
                for (int j = 1; j * j <= a; j++) {
                    if (a % j == 0 && a / j != j) {
                        bucket[a][1] += bucket[j][0];//Factorization: j
                        bucket[a][1] += bucket[a / j][0]; //Factorization: element/j
                    } else if (a % j == 0 && a / j == j) {
                        bucket[a][1] += bucket[j][0];
                    }
                }
            }
        }
        // using array A to set results for not arranging new space
        for (int i = 0; i < A.length; i++) {
            A[i] = A.length - bucket[A[i]][1];
        }
        return A;
    }

    public static void main(String[] args) {
        CountNonDivisible solution = new CountNonDivisible();
        int[] A = {3, 1, 2, 3, 6};
        int[] result = solution.solution(A);
        System.out.println(Arrays.toString(result)); // Output: [3, 4, 3, 3, 0]
    }
}
