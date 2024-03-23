package com.sunny.pdf.pdfutility.code;

public class ArrListLen {

    public int arrayListLength(int[] A) { //linked list
        int count = 0;
        int currentIndex = 0;

        // Traverse the linked list until we reach the end (value = -1)
        while (currentIndex != -1) {
            count++;
            currentIndex = A[currentIndex];
        }

        return count;
    }
}
