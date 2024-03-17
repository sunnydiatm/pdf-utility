package com.sunny.pdf.pdfutility.code;

public class HalloweenSale {

    public static int howManyGames(int p, int d, int m, int s) {
        int gamesBought = 0;
        int currentPrice = p;

        // Continue buying games while the budget is greater than or equal to the current price
        while (s >= currentPrice) {
            gamesBought++;
            s -= currentPrice;

            // Decrease the price for the next game
            if (currentPrice - d >= m) {
                currentPrice -= d;
            } else {
                currentPrice = m;
            }
        }

        return gamesBought;
    }

    public static void main(String[] args) {
        int p = 20; // Initial price
        int d = 3; // Price decrement
        int m = 6; // Minimum price
        int s = 70; // Total budget
        System.out.println(howManyGames(p, d, m, s)); // Output should be 6
    }
}

