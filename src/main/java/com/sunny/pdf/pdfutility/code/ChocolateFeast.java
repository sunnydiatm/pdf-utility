package com.sunny.pdf.pdfutility.code;

public class ChocolateFeast {

    public static int chocolateFeast(int n, int c, int m) {
        int chocolates = n / c; // Number of chocolates Bobby can buy initially
        int wrappers = chocolates; // Number of wrappers Bobby has initially

        // Exchange wrappers for additional chocolates
        while (wrappers >= m) {
            int exchangedChocolates = wrappers / m; // Number of additional chocolates from exchanging wrappers
            chocolates += exchangedChocolates; // Add additional chocolates to total count
            wrappers = exchangedChocolates + (wrappers % m); // Calculate remaining wrappers
        }

        return chocolates;
    }

    public static void main(String[] args) {
        int n = 15; // Total dollars Bobby has
        int c = 3; // Cost per chocolate
        int m = 2; // Number of wrappers needed to exchange for one additional chocolate
        System.out.println(chocolateFeast(n, c, m)); // Output: 7
    }
}

