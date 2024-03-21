package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class LisaWorkbook {

    public static int workbook2(int n, int k, List<Integer> arr) {
        int specialProblems = 0;
        int pageNumber = 1;

        for (int chapter = 0; chapter < n; chapter++) {
            int problemsInChapter = arr.get(chapter);
            int currentPageProblems = 0;

            for (int problem = 1; problem <= problemsInChapter; problem++) {
                if (problem == pageNumber) {
                    specialProblems++;
                }

                currentPageProblems++;

                if (currentPageProblems == k || problem == problemsInChapter) {
                    pageNumber++;
                    currentPageProblems = 0;
                }
            }
        }

        return specialProblems;
    }


    public static void main(String[] args) {
        List<Integer> arr = List.of(4, 2, 6, 1, 10);
        int n = arr.size();
        int k = 3;
        System.out.println(workbook2(n, k, arr)); // Output: 4
    }
}
