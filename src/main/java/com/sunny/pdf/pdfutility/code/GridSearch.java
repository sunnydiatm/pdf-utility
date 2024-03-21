package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class GridSearch {

    public static String gridSearch(List<String> G, List<String> P) {
        int gridRows = G.size();
        int gridCols = G.get(0).length();
        int patternRows = P.size();
        int patternCols = P.get(0).length();

        for (int i = 0; i <= gridRows - patternRows; i++) {
            for (int j = 0; j <= gridCols - patternCols; j++) {
                if (isPatternFound(G, P, i, j)) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    private static boolean isPatternFound(List<String> G, List<String> P, int row, int col) {
        for (int i = 0; i < P.size(); i++) {
            for (int j = 0; j < P.get(0).length(); j++) {
                if (G.get(row + i).charAt(col + j) != P.get(i).charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> G = List.of("1234567890", "0987654321", "1111111111", "1111111111", "2222222222");
        List<String> P = List.of("876543", "111111", "111111");
        System.out.println(gridSearch(G, P)); // Output: YES
    }

}
