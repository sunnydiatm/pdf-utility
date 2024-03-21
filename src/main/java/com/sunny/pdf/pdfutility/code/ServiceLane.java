package com.sunny.pdf.pdfutility.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceLane {

    public static List<Integer> serviceLane(int n, List<Integer> width, List<List<Integer>> cases) {
        List<Integer> maxWidth = new ArrayList<>();

        for (int i = 0; i < cases.size(); i++) {
            int startIndex = cases.get(i).get(0);
            int endIndex = cases.get(i).get(1);

            List<Integer> tempArray = new ArrayList<>(width.subList(startIndex, endIndex + 1));
            Collections.sort(tempArray);
            maxWidth.add(tempArray.get(0));
        }
        return maxWidth;
    }
}
