package com.sunny.pdf.pdfutility.code;

public class UtopianTree {

    public int utopianTree(int n) {
        // Write your code here
        int height = 1;
        for (int i = 0; i < n; i++) {
            if (i == 1 || i % 2 != 0) {
                height = height + 1;
            } else {
                height = height * 2;
            }
        }
        return height ;

    }

}
