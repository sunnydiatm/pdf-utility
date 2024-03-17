package com.sunny.pdf.pdfutility.code;

public class ViralAdvertising {

    public static int viralAdvertising2(int n) {
        // Write your code here

        int shared = 2;
        int cumulative = 2;
        for (int i = 2; i <= n; i++) {
            shared = (shared * 3) / 2;
            cumulative = cumulative + shared;
        }

        return cumulative;

    }

    public static int viralAdvertising(int n) {
        int people = 2;
        int count  = 2;
        for (int i = 2; i <= n; i++) {
            people = (people * 3) / 2;
            count += people;
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(viralAdvertising(2));
        System.out.println(viralAdvertising(2));
    }
}
