package com.sunny.pdf.pdfutility.code;

public class CountriesCount {

    private void dfs(int[][] A, boolean[][] visited, int row, int col, int color) {
        int N = A.length;
        int M = A[0].length;

        // Check if current area is valid and has the same color
        if (row < 0 || row >= N || col < 0 || col >= M || visited[row][col] || A[row][col] != color) {
            return;
        }

        // Mark current area as visited
        visited[row][col] = true;

        // Explore neighboring areas
        dfs(A, visited, row - 1, col, color); // Up
        dfs(A, visited, row + 1, col, color); // Down
        dfs(A, visited, row, col - 1, color); // Left
        dfs(A, visited, row, col + 1, color); // Right
    }

    public int countriesCount(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0; // No map or empty map
        }

        int count = 0;
        int N = A.length;
        int M = A[0].length;
        boolean[][] visited = new boolean[N][M];

        // Traverse the map and count connected components
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    count++; // Found a new country
                    dfs(A, visited, i, j, A[i][j]); // Explore connected areas
                }
            }
        }

        return count;
    }


}
