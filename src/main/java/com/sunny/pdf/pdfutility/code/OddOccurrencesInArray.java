package com.sunny.pdf.pdfutility.code;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public static Integer oddOccurrencesInArray(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Boolean> occurMap = new HashMap<Integer, Boolean>();
        for (int i = 0; i < A.length; i++) {
            if (occurMap.containsKey(A[i])) {
                if(occurMap.get(A[i])){
                    occurMap.put(A[i], false);
                }else {
                    occurMap.put(A[i], true);
                }
            }else {
                occurMap.put(A[i], false);
            }
        }
        for (Map.Entry<Integer, Boolean> set : occurMap.entrySet()) {
            if (set.getValue() == false) {
                return set.getKey();
            }
        }

        throw new RuntimeException("No value that occurs in odd number of elements.");
    }
}
