package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutTheSticks {

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        int[] inputArr = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            inputArr[i] = arr.get(i);
        }

        Arrays.sort(inputArr);
        List<Integer> list = new ArrayList<>();
        list.add(inputArr.length);
        for (int i = 1; i < inputArr.length; i++) {
            if (inputArr[i] != inputArr[i-1]) {
                list.add(inputArr.length - i);
            }
        }

        return list;

    }

    public static void main(String[] args) {
        System.out.println(cutTheSticks(List.of(1,2,3)));
    }
}
