package com.sunny.pdf.pdfutility.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubarray {

    public static int pickingNumbers(List<Integer> a) {
        // Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the pair of numbers with the highest frequency
        int maxFrequency = 0;
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Check if there exists a pair of consecutive numbers with adjacent frequencies
        int maxSubarrayLength = 0;
        for (int num : frequencyMap.keySet()) {
            int frequency1 = frequencyMap.getOrDefault(num, 0);
            int frequency2 = frequencyMap.getOrDefault(num + 1, 0);
            int subarrayLength = frequency1 + frequency2;
            maxSubarrayLength = Math.max(maxSubarrayLength, subarrayLength);
        }

        return maxSubarrayLength;
    }

    public static void main(String[] args) {
        List<Integer> a = List.of(4, 6, 5, 3, 3, 1);
        System.out.println("Length of the longest subarray: " + pickingNumbers(a));
    }
}

