package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagicSquareConverter {

    public static int formingMagicSquare(List<List<Integer>> s) {
        int minCost = Integer.MAX_VALUE;

        // Possible magic squares
        int[][][] magicSquares = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        for (int[][] magicSquare : magicSquares) {
            int cost = calculateCost(s, magicSquare);
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    private static int calculateCost(List<List<Integer>> s, int[][] magicSquare) {
        int cost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cost += Math.abs(s.get(i).get(j) - magicSquare[i][j]);
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        List<List<Integer>> s = new ArrayList<>();
        s.add(Arrays.asList(5, 3, 4));
        s.add(Arrays.asList(1, 5, 8));
        s.add(Arrays.asList(6, 4, 2));

        int minCost = formingMagicSquare(s);
        System.out.println("Minimal total cost of converting to a magic square: " + minCost);
    }
}

