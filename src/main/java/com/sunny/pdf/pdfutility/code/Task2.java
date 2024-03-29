package com.sunny.pdf.pdfutility.code;


/*
*
Given string S of length N consisting of letters A and B. Out goal is to obtain a string in A..AB...BB (all letters A occure before B)
Write a function that minimum number of letter that need to be deleted
public int solution(String S)
*
*/

public class Task2 {

    public int solution(String S) {

        if (S.isEmpty()) {
            return 0;
        }

        int countB = 0;
        int countDeletedA = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') {
                countDeletedA = Math.min(countDeletedA + 1, countB);
            } else {
                countB++;
            }
        }

        return countDeletedA;
    }

    public static void main(String[] args) {
        Task2  task2 = new Task2();
        System.out.println(task2.solution("BAAABAB"));
        System.out.println(task2.solution("BBABAA"));
        System.out.println(task2.solution("AABBBB"));
    }

}
