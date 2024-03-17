package com.sunny.pdf.pdfutility.code;

import java.util.HashMap;
import java.util.List;

public class MinimumDistances {

    public static int minimumDistances(List<Integer> a) {
        // Write your code here

        int[] array = new int[a.size()];

        for (int i = 0; i < a.size(); i++) {
            array[i] = a.get(i);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int prevIndex = map.get(array[i]);
                int currDistance = i - prevIndex;
                minDistance = Math.min(minDistance, currDistance);
            }
            map.put(array[i], i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;

    }
}
