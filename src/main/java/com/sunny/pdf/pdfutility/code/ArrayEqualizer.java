package com.sunny.pdf.pdfutility.code;

import org.springframework.util.RouteMatcher;

import java.util.*;

public class ArrayEqualizer {

    private static final int size = 100;

    public static int equalizeArray(List<Integer> list) { // todo - tested and working
        // Write your code here

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the element with the maximum frequency
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Calculate the minimum number of elements to delete
        return list.size() - maxFrequency;

    }

    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] counts = new int[size + 1]; // could alternatively use a HashMap
        for (int i = 0; i < n; i++) {
            counts[scan.nextInt()]++;
        }
        scan.close();
        System.out.println("n=> " + n);
        for (int a : counts) {
            System.out.println("count=> " + a);
        }
        int maxRepetitions = Arrays.stream(counts).max().getAsInt();
        System.out.println("maxRepetitions=> " + maxRepetitions);
        System.out.println(n - maxRepetitions);
    }*/

    public static void main(String[] args) {
        System.out.println(equalizeArray(List.of(1,2,2,3)));
        System.out.println(equalizeArray(List.of(3,3,2,1,3)));
    }
}
