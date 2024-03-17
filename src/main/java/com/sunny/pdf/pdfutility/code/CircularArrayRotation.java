package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.List;

public class CircularArrayRotation {

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here

        List<Integer> rotatedArray = new ArrayList<>();

        // Calculate the effective number of rotations
        k = k % a.size();

        // Perform circular rotations
        for (int i = 0; i < a.size(); i++) {
            int newIndex = (i + a.size() - k) % a.size();
            rotatedArray.add(a.get(newIndex));
        }

        // Retrieve elements at specified indices
        List<Integer> result = new ArrayList<>();
        for (int index : queries) {
            result.add(rotatedArray.get(index));
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(circularArrayRotation(List.of(3,4,5), 2, List.of(0,1,2)));
    }
}
