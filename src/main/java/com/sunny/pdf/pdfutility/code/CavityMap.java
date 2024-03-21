package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class CavityMap {

    public static List<String> cavityMap(List<String> grid) {
        int n = grid.size();
        List<String> result = new ArrayList<>();

        // Convert grid to char array
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = grid.get(i).toCharArray();
        }

        // Iterate through each cell in the grid
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                // Check if the cell is a cavity
                if (isCavity(map, i, j)) {
                    // Replace depth with 'X'
                    map[i][j] = 'X';
                }
            }
        }

        // Convert char array back to grid
        for (char[] row : map) {
            result.add(String.valueOf(row));
        }

        return result;
    }

    // Helper method to check if a cell is a cavity
    private static boolean isCavity(char[][] map, int i, int j) {
        int depth = map[i][j] - '0';
        // Check if each adjacent cell has smaller depth
        return depth > map[i - 1][j] - '0' &&
                depth > map[i + 1][j] - '0' &&
                depth > map[i][j - 1] - '0' &&
                depth > map[i][j + 1] - '0';
    }

    public static void main(String[] args) {
        List<String> grid = List.of("1112", "1912", "1892", "1234");
        List<String> result = cavityMap(grid);
        for (String row : result) {
            System.out.println(row);
        }
    }
}
