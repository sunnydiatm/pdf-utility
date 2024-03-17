package com.sunny.pdf.pdfutility.code;

import java.time.LocalDate;

public class LibraryFine {

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Write your code here

        LocalDate returnDate = LocalDate.of(y1, m1, d1);
        LocalDate expectDate = LocalDate.of(y2, m2, d2);

        int fine;
        if (returnDate.isEqual(expectDate) || returnDate.isBefore(expectDate)) {
            fine = 0;
        } else if (returnDate.getMonth() == expectDate.getMonth() && returnDate.getYear() == expectDate.getYear()) {
            fine = 15 * (returnDate.getDayOfMonth() - expectDate.getDayOfMonth());
        } else if (returnDate.getYear() == expectDate.getYear()) {
            fine = 500 * (returnDate.getMonthValue() - expectDate.getMonthValue());
        } else {
            fine = 10000;
        }

        return fine;

    }

    public static void main(String[] args) {
        System.out.println(libraryFine(9,6,2015,6,6,2015));
    }
}
