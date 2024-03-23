package com.sunny.pdf.pdfutility.code;

import java.util.HashMap;

public class FirstUnique {

    public int solution(int[] A) {
        // Implement your solution here
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Iterate through the array and update frequency count
        for (int num : A) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Iterate through the array again to find the first unique number
        for (int num : A) {
            if (frequencyMap.get(num) == 1) {
                return num; // Found the first unique number
            }
        }

        // If no unique number found, return -1
        return -1;
    }
}
