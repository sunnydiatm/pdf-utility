package com.sunny.pdf.pdfutility.code;

public class StringSymmetryPoint {

    public int stringSymmetryPoint(String S) {
        // write your code in Java SE 8
        int length = S.length();
        if (length == 0)
            return -1;
        int tail = 0;
        int head = length - 1;
        int result = 0;
        while (tail < head) {
            // symmetry character exists
            if (S.charAt(tail) == S.charAt(head)) {
                tail++;
                head--;
                // symmetry character not exists
            } else
                return -1;
        }
        // find the index
        if (tail == head)
            return tail;
            // can not find the index
        else
            return -1;
    }
}
