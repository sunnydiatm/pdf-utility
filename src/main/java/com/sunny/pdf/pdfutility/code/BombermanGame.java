package com.sunny.pdf.pdfutility.code;

import java.util.*;

public class BombermanGame {

    public static List<String> bomberMan(int n, List<String> grid) {
    int r = grid.size();
    int c = grid.get(0).length();

    char[][] matrix = new char[r][c];

        if (n == 1) {
        return grid;
    }
        if (n % 2 == 0) {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String s = "";
            for (int j = 0; j < c; j++) {
                s += "O";
            }
            result.add(s);
        }
        return result;

    }

    Set<Integer> bombs = getMatrix(grid, c, matrix);

    n = (n % 4 == 1) ? 5 : 3;

    Set<Integer> nextBombs = new HashSet<>();

        for (int t = 1; t < n; t++) {
        if (t % 2 == 1) {
            fillBombs(c, matrix, nextBombs);
        } else {
            detonateBombs(r, c, matrix, bombs, nextBombs);
            bombs = nextBombs;
            nextBombs = new HashSet<>();

        }
    }

        return getResult(r, c, matrix);
}

private static Set<Integer> getMatrix(List<String> grid, int c, char[][] matrix) {
    Set<Integer> bombs = new HashSet<>();

    ListIterator<String> listIterator = grid.listIterator();
    while (listIterator.hasNext()) {
        int i = listIterator.nextIndex();
        String row = listIterator.next();

        for (int j = 0; j < row.length(); j++) {
            if (row.charAt(j) == 'O') {

                bombs.add(i * c + j);
            }
            matrix[i][j] = row.charAt(j);
        }
    }
    return bombs;
}

private static void detonateBombs(int r, int c, char[][] matrix, Set<Integer> bombs, Set<Integer> nextBombs) {
    for (Integer bomb : bombs) {

        int i = bomb / c;
        int j = bomb % c;
        nextBombs.remove(i * c + j);
        matrix[i][j] = '.';
        if (i > 0) {

            nextBombs.remove((i - 1) * c + j);
            matrix[i - 1][j] = '.';
        }
        if (i < r - 1) {
            nextBombs.remove((i + 1) * c + j);
            matrix[i + 1][j] = '.';
        }
        if (j > 0) {
            nextBombs.remove(i * c + j - 1);
            matrix[i][j - 1] = '.';
        }
        if (j < c - 1) {
            nextBombs.remove(i * c + j + 1);
            matrix[i][j + 1] = '.';
        }
    }
}

private static void fillBombs(int c, char[][] matrix, Set<Integer> nextBombs) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == '.') {

                nextBombs.add(i * c + j);
                matrix[i][j] = 'O';
            }
        }
    }
}

private static List<String> getResult(int r, int c, char[][] matrix) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < r; i++) {
        String s = "";
        for (int j = 0; j < c; j++) {

            s += matrix[i][j];
        }
        result.add(s);
    }
    return result;
}

}
