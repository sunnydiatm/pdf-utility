package com.sunny.pdf.pdfutility.code;

import java.util.Arrays;


/*
*
There are n trees in a forest the kth trees located at co-ordinate (x[k] ,Y[k]) want to build widest possible vertical path such that there is no tree on it.
The path must be build somewhere between leftmost and rightmost tree which means width of the path not infinite
what is the widest possible path that can be built?
public int solution(int[] x, int[] y);
*
*/

public class Task1 {

    public int solution(int[] x, int[] y) {
        int n = x.length;
        if (n <= 1) {
            return 0; // No path can be built if there is only one tree or no trees
        }

        Arrays.sort(x);
        int maxWidth = 0;

        for (int i = 1; i < n; i++) {
            int width = x[i] - x[i - 1];
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }

    public int solution2(int[] x, int[] y) {
        int n = x.length;

        if (n <= 1) {
            return 0;
        }

        Arrays.sort(x);
        int maxWidth = 0;

        for (int i = 1; i < n; i++) {
            int width = x[i] - x[i - 1];
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        int[] x1 = {5, 10, 15, 20, 25};
        int[] y1 = {5, 10, 5, 10, 5};
        System.out.println(task1.solution2(x1, y1));

        int[] x2 = {1, 8,7,3,4,1,8};
        int[] y2 = {6,4,1,8,5,1,7};
        System.out.println(task1.solution2(x2, y2));
    }


    }
