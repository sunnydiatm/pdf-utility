package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class ManasaAndStones {

    public static List<Integer> stones(int n, int a, int b) {
        // Write your code here

        List<Integer> result = new ArrayList<>();
        if (a == b) {
            result.add((n - 1) * a);
        } else {
            if (a > b) {
                /* swap to make "a" the smaller value */
                int temp = a;
                a = b;
                b = temp;
            }
            for (int i = 0; i <= n - 1; i++) {
                result.add(a*(n-1-i) + b*i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(stones(2,2,3));
    }
}
