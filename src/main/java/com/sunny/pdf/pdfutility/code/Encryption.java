package com.sunny.pdf.pdfutility.code;

public class Encryption {

    public static String encryption(String s) {
        // Remove spaces from the text
        s = s.replaceAll("\\s+", "");

        // Calculate the number of rows and columns for the grid
        int length = s.length();
        double sqrtLength = Math.sqrt(length);
        int rows = (int) Math.floor(sqrtLength);
        int columns = (int) Math.ceil(sqrtLength);
        if (rows * columns < length) {
            rows++;
        }

        // Arrange characters into the grid
        StringBuilder[] grid = new StringBuilder[columns];
        for (int i = 0; i < columns; i++) {
            grid[i] = new StringBuilder();
        }
        for (int i = 0; i < length; i++) {
            grid[i % columns].append(s.charAt(i));
        }

        // Concatenate characters column-wise to form the encrypted string
        StringBuilder encrypted = new StringBuilder();
        for (StringBuilder column : grid) {
            encrypted.append(column).append(" ");
        }

        return encrypted.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(encryption("have a nice day"));
    }

}
