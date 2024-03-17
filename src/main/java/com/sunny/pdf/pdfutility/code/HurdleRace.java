package com.sunny.pdf.pdfutility.code;

import java.util.List;

public class HurdleRace {

    public int hurdleRace(int k, List<Integer> height) {
        // Write your code here
        int hurdleCount = 0;
        for (int i = 0; i < height.size(); i++) {
            if (height.get(i) > k) {
                int diff = height.get(i) - k ;
                if (hurdleCount < diff) {
                    hurdleCount = diff;
                }
            }
        }
        return hurdleCount;
    }
}
