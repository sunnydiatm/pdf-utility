package com.sunny.pdf.pdfutility.code;

public class BinaryGap {

    public static int solution(int N) {
        String binary = Integer.toBinaryString(N);
        int maxGap = 0;
        int currentGap = 0;
        boolean countGap = false;

        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == '1') {
                if (countGap && currentGap > maxGap) {
                    maxGap = currentGap;
                }
                currentGap = 0;
                countGap = true;
            } else if (countGap) {
                currentGap++;
            }
        }

        return maxGap;
    }

    public static void main(String[] args) {
        int N = 1041; // Example input
        System.out.println("Longest binary gap for N = " + N + ": " + solution(N)); // Output: 5
    }
}

