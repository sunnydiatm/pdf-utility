package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationEquation {

    public static List<Integer> permutationEquation(List<Integer> p) {
        List<Integer> result = new ArrayList<>();

        // Map to store the index of each element in p
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < p.size(); i++) {
            indexMap.put(p.get(i), i + 1); // Index starts from 1
        }

        // Iterate over x from 1 to n and find corresponding values of y
        for (int x = 1; x <= p.size(); x++) {
            int y = indexMap.get(indexMap.get(x)); // y = p[p[x]]
            result.add(y);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> p = List.of(5, 2, 1, 3, 4);
        List<Integer> result = permutationEquation(p);
        System.out.println("Values of y for each x: " + result);
    }
}
