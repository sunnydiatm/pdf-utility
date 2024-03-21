package com.sunny.pdf.pdfutility.code;

public class StrangeCounter {

    public static long strangeCounter(long t) {
        long cycle = 0;
        long cycleStartValue = 1;
        long cycleLength = 3;

        // Find the cycle that contains the given time t
        while (t > cycleStartValue + cycleLength - 1) {
            cycle++;
            cycleStartValue += cycleLength;
            cycleLength *= 2;
        }

        // Calculate the value at time t within the cycle
        long valueAtT = cycleStartValue + cycleLength - t;

        return valueAtT;
    }

    public static void main(String[] args) {
        long t1 = 4;
        long t2 = 17;
        long t3 = 15;
        System.out.println(strangeCounter(t1)); // Output: 6
        System.out.println(strangeCounter(t2)); // Output: 5
    }
}
