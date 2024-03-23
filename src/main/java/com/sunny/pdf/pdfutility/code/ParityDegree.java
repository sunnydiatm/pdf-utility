package com.sunny.pdf.pdfutility.code;

public class ParityDegree {

    public int parityDegree(int N) {
        // Initialize count to 0
        int count = 0;

        // Keep right-shifting N until it becomes 0 or the last bit is 1
        while (N > 0 && (N & 1) == 0) {
            N >>= 1; // Right shift N by 1
            count++; // Increment count
        }

        // Return the count as the highest power of 2 that divides N
        return count;
    }
}
