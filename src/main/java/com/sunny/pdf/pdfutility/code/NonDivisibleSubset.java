package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Count the frequency of each remainder when dividing each number by k
        int[] remainders = new int[k];
        for (int num : s) {
            remainders[num % k]++;
        }

        // Count the size of the maximal subset
        int count = 0;
        for (int i = 1; i <= k / 2; i++) {
            // If i and k-i are the same remainder, we can only choose one
            if (i != k - i) {
                count += Math.max(remainders[i], remainders[k - i]);
            } else {
                // If i and k-i are the same remainder, we can only choose one
                count += Math.min(1, remainders[i]);
            }
        }

        // Include the number with remainder 0 if it exists
        count += Math.min(1, remainders[0]);

        return count;
    }


    public static void main(String[] args) {
        System.out.println(nonDivisibleSubset(4, List.of(19,10,12, 10, 24, 25,22)));
    }
}
