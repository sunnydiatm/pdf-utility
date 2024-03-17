package com.sunny.pdf.pdfutility.code;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueensAttack {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Set to store the positions of obstacles
        Set<String> obstacleSet = new HashSet<>();
        for (List<Integer> obstacle : obstacles) {
            obstacleSet.add(obstacle.get(0) + "," + obstacle.get(1));
        }

        int count = 0;

        // Directions for queen's movements
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        // Iterate over all directions
        for (int[] direction : directions) {
            int row = r_q;
            int col = c_q;

            // Move in the current direction until reaching an obstacle or board boundary
            while (isValid(row + direction[0], col + direction[1], n) && !obstacleSet.contains((row + direction[0]) + "," + (col + direction[1]))) {
                row += direction[0];
                col += direction[1];
                count++;
            }
        }

        return count;
    }

    // Check if the given position is valid on the board
    private static boolean isValid(int row, int col, int n) {
        return row >= 1 && row <= n && col >= 1 && col <= n;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int r_q = 4;
        int c_q = 3;
        List<List<Integer>> obstacles = List.of(
                List.of(5, 5),
                List.of(4, 2),
                List.of(2, 3)
        );

        System.out.println("Number of squares the queen can attack: " + queensAttack(n, k, r_q, c_q, obstacles));
    }
}

