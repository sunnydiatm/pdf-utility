package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountNonDivisible {

    public int[] solution(int[] A) {
        int N = A.length;
        int[] result = new int[N];

        // Calculate divisors for each element in A
        for (int i = 0; i < N; i++) {
            int current = A[i];
            Set<Integer> divisors = new HashSet<>();
            for (int j = 1; j * j <= current; j++) {
                if (current % j == 0) {
                    divisors.add(j);
                    divisors.add(current / j);
                }
            }

            // Count the number of elements in A that are not divisors of current
            int count = 0;
            for (int num : A) {
                if (!divisors.contains(num)) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        CountNonDivisible solution = new CountNonDivisible();
        int[] A = {3, 1, 2, 3, 6};
        int[] result = solution.solution(A);
        System.out.println(Arrays.toString(result)); // Output: [3, 4, 3, 3, 0]
    }
}
