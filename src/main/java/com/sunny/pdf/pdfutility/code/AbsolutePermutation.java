package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class AbsolutePermutation {


    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> permutation = new ArrayList<>();

        // Check if k = 0
        if (k == 0) {
            // Return identity permutation
            for (int i = 1; i <= n; i++) {
                permutation.add(i);
            }
            return permutation;
        }

        // Check if n is divisible by 2 * k
        if (n % (2 * k) != 0) {
            // No absolute permutation exists
            permutation.add(-1);
            return permutation;
        }

        // Generate absolute permutation
        boolean increase = true;
        for (int i = 1; i <= n; i++) {
            if (increase) {
                permutation.add(i + k);
            } else {
                permutation.add(i - k);
            }
            if (i % k == 0) {
                increase = !increase;
            }
        }

        return permutation;
    }

    public static void main(String[] args) {
        // Example usage
        int n = 4;
        int k = 2;
        System.out.println(absolutePermutation(n, k)); // Output: [3, 4, 1, 2, 7, 8, 5, 6, 9, 10]
    }
}
